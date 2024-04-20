package com.example.javatechtask.servise;

import com.example.javatechtask.dtos.TotalSaletByDateDTO;
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
import java.util.Objects;

@Data
@Service
public class GetSummaryByDateRange {

    //    @Autowired
    private final MongoTemplate mongoTemplate;

    public GetSummaryByDateRange(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public String getSumByDateRange(String startDate, String endDate) {

        // Выполняем агрегацию
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("date").gte(startDate).lte(endDate)),

                Aggregation.group()
                        .sum("salesByDate.orderedProductSales.amount").as("totalOrderedProductSalesAmount")
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

        AggregationResults<TotalSaletByDateDTO> results =
                mongoTemplate.aggregate(aggregation,
                        "salesAndTrafficByDate",
                        TotalSaletByDateDTO.class);

        mongoTemplate.insert(Objects.requireNonNull(results.getUniqueMappedResult())
                ,"salesAndTrafficByDate "+startDate+ " " +endDate);



//         results.getRawResults().toJson();
//        ToyalSaletByDateDTO uniqueMappedResult = results.getUniqueMappedResult();
        TotalSaletByDateDTO uniqueMappedResult = results.getUniqueMappedResult();

//        String resultJson = results.getRawResults().toJson(); //resultsArray.get(0).getAsJsonObject();

// Создаем ObjectMapper
//        ObjectMapper objectMapper = new ObjectMapper();

//        try {
//            // Преобразуем JSON-строку в JsonNode
//            JsonNode jsonNode = objectMapper.readTree(resultJson);
//
//            // Получаем значения полей
//            double totalOrderedProductSalesAmount = jsonNode.get("totalOrderedProductSalesAmount").asDouble();
//            double totalOrderedProductSalesB2B = jsonNode.get("totalOrderedProductSalesB2B").asDouble();
//            // Продолжайте для других полей
//
//            // Делайте что-то с полученными значениями, например, выводите их
//            System.out.println("Total Ordered Product Sales Amount: " + totalOrderedProductSalesAmount);
//            System.out.println("Total Ordered Product Sales B2B: " + totalOrderedProductSalesB2B);
//            // Выводите другие поля аналогичным образом
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Создаем ObjectMapper

//        return results.getUniqueMappedResult();
        return results.getRawResults().toJson();

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
