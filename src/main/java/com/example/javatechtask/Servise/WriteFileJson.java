package com.example.javatechtask.Servise;

import com.example.javatechtask.models.SalesAndTrafficByAsin;
import com.example.javatechtask.models.SalesAndTrafficByDate;
import com.example.javatechtask.models.SalesAndTrafficReport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Slf4j
@Component
public class WriteFileJson {
    private final MongoTemplate mongoTemplate;

    public WriteFileJson(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public SalesAndTrafficReport WriteFileJsonPars() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        //Step 2: Add Jackson Dependency
// https://www.geeksforgeeks.org/how-to-read-and-write-json-files-in-java/?ref=ml_lbp
        log.info("Reading data from a file..");
        SalesAndTrafficReport report = objectMapper.readValue(new File("src/main/resources/raznoe/test_report.json")
                , SalesAndTrafficReport.class);
//
        log.info("Write to the database from a file in SalesAndTrafficReport.class successfully.");

        int countTrafficyDate =0;
        int countTrafficByAsin =0;
        mongoTemplate.insert(report.getReportSpecification());
        log.info("->Write to the database from the file was saved successfully.");
        for (SalesAndTrafficByDate salesAndTrafficByDate : report.getSalesAndTrafficByDate()) {
            mongoTemplate.insert(salesAndTrafficByDate);
            countTrafficyDate ++;
        }log.info("->Write SalesAndTrafficByDate to the database from the file was saved successfully. Array "
                + countTrafficyDate);

        for (SalesAndTrafficByAsin salesAndTrafficByAsin : report.getSalesAndTrafficByAsin()) {
            mongoTemplate.insert(salesAndTrafficByAsin);
            countTrafficByAsin ++;

        }log.info("->Write to SalesAndTrafficByAsin the database from the file was saved successfully. Array "
                + countTrafficByAsin);

        return mongoTemplate.insert(report);
    }

    public ResponseEntity<String> FileFromData(String date) {
        MongoCollection<Document> collection = mongoTemplate.getCollection("salesAndTrafficReport");
//        Bson filter = Filters.eq("salesAndTrafficByDate.date", date);

        // Создаем фильтр для поиска элементов массива, которые содержат только заданную дату
        Bson arrayFilter = Filters.elemMatch("salesAndTrafficByDate", Filters.eq("date", date));
        // Создаем проекцию, чтобы вернуть только элементы массива, которые удовлетворяют фильтру
        Bson projection = Projections.elemMatch("salesAndTrafficByDate", Filters.eq("date", date));

        // Применяем фильтр к коллекции
        MongoCursor<Document> cursor = collection.find(arrayFilter)
                .projection(projection)
                .iterator();

        StringBuilder stringBuilder = new StringBuilder();
        try {
//            while (cursor.hasNext()) {
//                Document doc = cursor.next();
//                stringBuilder.append(doc.toJson()).append("\n");
//            }
            cursor.forEachRemaining(doc -> stringBuilder.append(doc.toJson()).append("\n"));
        } finally {
            cursor.close();
        }
        return ResponseEntity.ok(stringBuilder.toString());
    }

    public ResponseEntity<String> filterBetweenDates(String firstDate, String endDate) {
//        MongoCollection<Document> collection = mongoTemplate.getCollection("salesAndTrafficReport");
//
//        // Создаем фильтр для выбора элементов массива с датами в заданном диапазоне
//        Bson arrayFilter = Filters.and(
//                Filters.gte("salesAndTrafficByDate.date", firstDate), // Больше или равно первой дате
//                Filters.lt("salesAndTrafficByDate.date", endDate)    // Меньше второй даты
//        );
//
//        Bson projection = Projections.elemMatch("salesAndTrafficByDate", Filters.eq("date", date));
//
//        // Применяем фильтр к коллекции
//        MongoCursor<Document> cursor = collection.find(arrayFilter).iterator();
//
//        StringBuilder stringBuilder = new StringBuilder();
//        try {
//            cursor.forEachRemaining(doc -> stringBuilder.append(doc.toJson()).append("\n"));
//        } finally {
//            cursor.close();
//        }
//        return ResponseEntity.ok(stringBuilder.toString());
        return null;
    }


}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//Конечно, давайте создадим полный пример, который выполняет поиск объектов в MongoDB по заданному диапазону дат и затем суммирует значения различных полей из этих объектов. В этом примере я предполагаю, что у вас есть класс `YourEntity`, который представляет собой объекты, сохраняемые в MongoDB. Вам также нужен репозиторий `YourRepository` для выполнения запросов к базе данных.
//
//Предположим, что у вас есть класс `YourEntity` с полями, которые содержат информацию о продажах и трафике на определенную дату. Вот как может выглядеть этот класс:
//
//        ```java
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection = "your_collection_name")
//public class YourEntity {
//    @Id
//    private String id;
//    private String date;
//    private SalesByDate salesByDate;
//    private TrafficByDate trafficByDate;
//
//    // Геттеры и сеттеры
//}
//```
//
//А также предположим, что у вас есть классы `SalesByDate` и `TrafficByDate`, представляющие данные о продажах и трафике на определенную дату.
//
//Теперь давайте реализуем репозиторий `YourRepository`:
//
//        ```java
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//import java.util.List;
//
//public interface YourRepository extends MongoRepository<YourEntity, String> {
//
//    @Query("{ 'date' : { $gt: ?0, $lt: ?1 } }")
//    List<YourEntity> findByDateRange(String startDate, String endDate);
//}
//```
//
//Теперь давайте создадим сервис, который будет выполнять поиск и суммирование данных:
//
//        ```java
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class YourService {
//
//    @Autowired
//    private YourRepository yourRepository;
//
//    public void processDateRange(String startDate, String endDate) {
//        List<YourEntity> result = yourRepository.findByDateRange(startDate, endDate);
//
//        double totalSales = 0;
//        int totalUnitsOrdered = 0;
//        int totalOrdersShipped = 0;
//        // Другие переменные, которые вы хотите сложить
//
//        for (YourEntity entity : result) {
//            totalSales += entity.getSalesByDate().getOrderedProductSales().getAmount();
//            totalUnitsOrdered += entity.getSalesByDate().getUnitsOrdered();
//            totalOrdersShipped += entity.getSalesByDate().getOrdersShipped();
//            // Другие операции с данными
//        }
//
//        System.out.println("Общая сумма продаж: " + totalSales);
//        System.out.println("Общее количество заказанных единиц: " + totalUnitsOrdered);
//        System.out.println("Общее количество отгруженных заказов: " + totalOrdersShipped);
//        // Другие выводы или операции с результатами
//    }
//}
//```
//
//Наконец, давайте вызовем этот сервис из нашего контроллера или из другого компонента:
//
//        ```java
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class YourController {
//
//    @Autowired
//    private YourService yourService;
//
//    @GetMapping("/process")
//    public void processDateRange(@RequestParam String startDate, @RequestParam String endDate) {
//        yourService.processDateRange(startDate, endDate);
//    }
//}
//```
//
//Теперь, когда вы вызываете `/process` с параметрами `startDate` и `endDate`, сервис выполнит поиск в MongoDB по указанному диапазону дат и затем суммирует данные из найденных объектов.