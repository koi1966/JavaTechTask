package com.example.javatechtask.servise;

import com.example.javatechtask.models.SalesAndTrafficByDate;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class GetSummaryByDateRange {

    @Autowired
    private MongoTemplate mongoTemplate;

//    public SalesAndTrafficByDate getSumByDateRange(LocalDate startDate, LocalDate endDate) {
    public Document getSumByDateRange(String startDate, String endDate) {
        // Строим запрос по начальной и конечной дате
        Query query = new Query();
        query.addCriteria(Criteria.where("date").gte(startDate).lte(endDate));

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

        AggregationResults<SalesAndTrafficByDate> results = mongoTemplate.aggregate(aggregation, "salesAndTrafficByDate", SalesAndTrafficByDate.class);
        return results.getRawResults();
//        return results.getUniqueMappedResult();
    }
}
