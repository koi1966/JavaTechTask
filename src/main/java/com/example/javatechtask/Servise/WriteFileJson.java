package com.example.javatechtask.Servise;

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
        log.info("->Reading data from a file..");
        SalesAndTrafficReport report = objectMapper.readValue(new File("src/main/resources/raznoe/test_report.json")
                ,SalesAndTrafficReport.class);
//
        log.info("->Write to the database from the file was saved successfully.");
        return mongoTemplate.insert(report);
    }

    public ResponseEntity<String> FileFromData(String date) {
        MongoCollection<Document> collection = mongoTemplate.getCollection("salesAndTrafficReport");
        Bson filter = Filters.eq("salesAndTrafficByDate.date", date);

//        Bson filter = Filters.and(
//                Filters.gte("date", "2024-02-14"), // Больше или равно указанной даты
//                Filters.lt("date", "2024-02-17")   // Меньше указанной даты
//        );

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

    public ResponseEntity<String> filterBetweenData(String firstDate, String endDate) {
        MongoCollection<Document> collection = mongoTemplate.getCollection("salesAndTrafficReport");

        Bson filter = Filters.and(
                Filters.gte("salesAndTrafficByDate.date", firstDate), // Больше или равно указанной даты
                Filters.lt("salesAndTrafficByDate.date", endDate)    // Меньше указанной даты
        );


        MongoCursor<Document> cursor = collection.find(filter).iterator();

        StringBuilder stringBuilder = new StringBuilder();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                stringBuilder.append(doc.toJson()).append("\n");
            }
        } finally {
            cursor.close();
        }

        return ResponseEntity.ok(stringBuilder.toString());
    }
}



















//        File file = new File("c:\\1\\employee2.json");
//                employee = objectMapper.readValue(file, Employee.class);
//       List<Employee> employeeList = objectMapper.readValue(file, new TypeReference<List<Employee>>() {});
//        document.insertMany((ClientSession) employeeList, (List<? extends Document>) document);
//        employee.setId(UUID.randomUUID());
//        employeeRepository.save(employee);

// Преобразовать список объектов Employee в список документов
//        List<Document> documents = employeeList.stream()
//                .map(employee -> new Document()
//                        .append("firstName", employee.getFirstName())
//                        .append("lastName", employee.getLastName())
//                        .append("age", employee.getAge()))
//                .toList();
//
//        // Записать список документов в коллекцию MongoDB
//        collection.insertMany(documents);

// Зарегистрируем кодек для класса Employee
