package com.example.javatechtask.servise;

import com.example.javatechtask.dtos.SalesAndTrafficByDateDTO;
import com.example.javatechtask.models.OrderedProductSales;
import com.example.javatechtask.models.SalesAndTrafficByDate;
import com.example.javatechtask.models.SalesByDate;
import com.example.javatechtask.models.TrafficByDate;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import lombok.Data;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Service
public class GetSummaryByDateRange {

    //    @Autowired
    private final MongoTemplate mongoTemplate;

    public GetSummaryByDateRange(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public SalesAndTrafficByDateDTO getSumByDateRange(String startDate, String endDate) {
//    public Document getSumByDateRange(String startDate, String endDate) {
        // Строим запрос по начальной и конечной дате
//        Query query = new Query();
//        query.addCriteria(Criteria.where("date").gte(startDate).lte(endDate));

        // Выполняем агрегацию
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("date").gte(startDate).lte(endDate)),

                Aggregation.group()
                        .sum("salesByDate.orderedProductSales.amount").as("totalOrderedProductSales")
                        .sum("salesByDate.orderedProductSalesB2B.amount").as("totalOrderedProductSalesB2B")
                        .sum("salesByDate.unitsOrdered").as("totalUnitsOrdered")
                        .sum("salesByDate.unitsOrderedB2B").as("totalUnitsOrderedB2B")
                        .sum("salesByDate.totalOrderItems").as("totalOrderItems")
                        .sum("salesByDate.totalOrderItemsB2B").as("totalOrderItemsB2B")
                        .sum("salesByDate.unitsShipped").as("totalUnitsShipped")
                        .sum("salesByDate.ordersShipped").as("totalOrdersShipped")
                        .sum("trafficByDate.browserPageViews").as("totalBrowserPageViews")
                        .sum("trafficByDate.browserPageViewsB2B").as("totalBrowserPageViewsB2B")
                        .sum("trafficByDate.mobileAppPageViews").as("totalMobileAppPageViews")
                        .sum("trafficByDate.mobileAppPageViewsB2B").as("totalMobileAppPageViewsB2B")
                        .sum("trafficByDate.pageViews").as("totalPageViews")
                        .sum("trafficByDate.pageViewsB2B").as("totalPageViewsB2B")
                        .sum("trafficByDate.browserSessions").as("totalBrowserSessions")
                        .sum("trafficByDate.browserSessionsB2B").as("totalBrowserSessionsB2B")
                        .sum("trafficByDate.mobileAppSessions").as("totalMobileAppSessions")
                        .sum("trafficByDate.mobileAppSessionsB2B").as("totalMobileAppSessionsB2B")
                        .sum("trafficByDate.sessions").as("totalSessions")
                        .sum("trafficByDate.sessionsB2B").as("totalSessionsB2B")
        );

        AggregationResults<SalesAndTrafficByDate> results = mongoTemplate.aggregate(aggregation,
                "salesAndTrafficByDate",
                SalesAndTrafficByDate.class);

        //*********************************************************
        SalesAndTrafficByDateDTO instance = new SalesAndTrafficByDateDTO();
        // Устанавливаем значение для поля date
        instance.setDate("Sum between two dates " + startDate + " : " + endDate);

        // Создаем экземпляр класса SalesByDate
        SalesByDate salesByDate = new SalesByDate();


        // Создаем экземпляр класса OrderedProductSales
        OrderedProductSales productSales = new OrderedProductSales();
        productSales.setAmount(totalSalesAmount);
        productSales.setCurrencyCode(totalSalesCurrencyCode);

        // Устанавливаем значения для полей класса SalesByDate
        salesByDate.setUnitsOrdered(totalUnitsOrdered);
        salesByDate.setUnitsOrdered(totalOrdersShipped);

        //                  .getOrderedProductSales().setAmount(totalSales);
//                setSalesByDate.setOrderedProductSales().setAmount(totalSales);
//        result.getSalesByDate().getOrderedProductSales().setAmount(totalSales);
//        result.getSalesByDate().setUnitsOrdered(totalUnitsOrdered);
//        result.getSalesByDate().setOrdersShipped(totalOrdersShipped);
//        result.getSalesByDate().getOrderedProductSales().setAmount(totalSales);
//        result.getTrafficByDate().setBrowserPageViews(totalPageViews);
//        result.getTrafficByDate().setMobileAppPageViews(totalMobileAppPageViews);

        // Другие выводы или операции с результатами
        salesByDate.setOrderedProductSales(productSales);
// Устанавливаем объект SalesByDate в экземпляр класса SalesAndTrafficByDate
        instance.setSalesByDate(salesByDate);


        // Создаем экземпляр класса TrafficByDate
        TrafficByDate trafficByDate = new TrafficByDate();
        // Устанавливаем значения для полей класса TrafficByDate
        // (если они есть и они необходимы)

        // Устанавливаем объект TrafficByDate в экземпляр класса SalesAndTrafficByDate
        instance.setTrafficByDate(trafficByDate);

        // Теперь у вас есть экземпляр класса SalesAndTrafficByDate
        // с заполненными полями date, salesByDate и trafficByDate


        // Возвращаем список с одним элементом - объектом result
        return instance;

        // ******************************************************


        //return results.getRawResults();
//        return results.getUniqueMappedResult();
    }


    public ResponseEntity<String> getFindOneData(String date) {
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


    public ResponseEntity<String> getFindDataBetweenDates(String startDate, String endDate) {
        MongoCollection<Document> collection = mongoTemplate.getCollection("salesAndTrafficReport");

        // Преобразование строковых дат в объекты LocalDate
        LocalDate startLocalDate = LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate endLocalDate = LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("***********************************");
        System.out.println(startLocalDate.toString());
        System.out.println("***********************************");
        // Создание фильтра для выбора данных между датами
        Bson filter = Filters.and(
//                Filters.gte("salesAndTrafficReport.salesAndTrafficByDate.date", startLocalDate.toString()),
                Filters.gte("salesAndTrafficByDate.date", startDate),
//                Filters.lte("salesAndTrafficReport.salesAndTrafficByDate.date", endLocalDate.toString())
                Filters.lte("salesAndTrafficByDate.date", endDate)
        );

        // Запрос к базе данных
        MongoCursor<Document> cursor = collection.find(filter).iterator();

        // Обработка результатов запроса
        StringBuilder stringBuilder = new StringBuilder();
        try {
            cursor.forEachRemaining(doc -> stringBuilder.append(doc.toJson()).append("\n"));
        } finally {
            cursor.close();
        }
        return ResponseEntity.ok(stringBuilder.toString());
    }


}
