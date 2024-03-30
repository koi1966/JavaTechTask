package com.example.javatechtask.Servise;


import com.example.javatechtask.models.SalesAndTrafficByDate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
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
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("date").gt(startDate).lt(endDate)),
                Aggregation.group("date")
                        .sum("salesByDate.unitsOrdered").as("totalUnitsOrdered")
                        .sum("salesByDate.orderedProductSales.amount").as("totalAmountOrdered")
        );

        return mongoTemplate.aggregate(
                aggregation, "salesAndTrafficByDate", SalesAndTrafficByDate.class
        ).getMappedResults();
    }
}
