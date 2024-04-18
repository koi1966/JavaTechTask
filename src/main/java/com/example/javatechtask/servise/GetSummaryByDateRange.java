package com.example.javatechtask.servise;

import com.example.javatechtask.models.SalesAndTrafficByDate;
import com.example.javatechtask.models.SalesAndTrafficReport;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import lombok.Data;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    public Document getSumByDateRange(String startDate, String endDate) {
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

        return results.getRawResults();
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

        // Создание фильтра для выбора данных между датами
        Bson filter = Filters.and(
                Filters.gte("salesAndTrafficByDate.date", startLocalDate.toString()),
                Filters.lte("salesAndTrafficByDate.date", endLocalDate.toString())
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
