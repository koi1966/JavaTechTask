package com.example.javatechtask.servise;

import com.example.javatechtask.models.SalesAndTrafficByDate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AggregationService {

    private final MongoTemplate mongoTemplate;

    public AggregationService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<SalesAndTrafficByDate> aggregateSalesAndTraffic(String startDate, String endDate) {

        ProjectionOperation notField = Aggregation.project().andExpression("_id").as("id");
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("date").gt(startDate).lt(endDate)),
//                notField,
                Aggregation.group("date")
//                        .sum("salesByDate.orderedProductSales.amount").as("totalorderedProductSalesamount")
//                        .sum("salesByDate.orderedProductSalesB2B.amount").as("orderedProductSalesB2B.amount")
                        .sum("salesByDate.unitsOrdered").as("totalUnitsOrdered")
//                        .sum("salesByDate.orderedProductSales.amount").as("totalAmountOrdered")
                        .sum("salesByDate.unitsOrderedB2B").as("totalunitsOrderedB2B")
                        .sum("salesByDate.totalOrderItems").as("totaltotalOrderItems")
                        .sum("salesByDate.totalOrderItemsB2B").as("totaltotalOrderItemsB2B")
//                        .sum("salesByDate.averageSalesPerOrderItem.amount").as("totalaverageSalesPerOrderItemamount")
//                        .sum("salesByDate.averageSalesPerOrderItemB2B.amount").as("totalaverageSalesPerOrderItemB2Bamount")
                        .sum("salesByDate.averageUnitsPerOrderItem").as("totalaverageUnitsPerOrderItem")
                        .sum("salesByDate.averageUnitsPerOrderItemB2B").as("totalaverageUnitsPerOrderItemB2B")
        );

        return mongoTemplate.aggregate(
                aggregation, "salesAndTrafficByDate", SalesAndTrafficByDate.class
        ).getMappedResults();
    }
}
