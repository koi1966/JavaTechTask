package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.SalesAndTrafficByDate;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@EnableMongoRepositories
@Repository
public interface TrafficByDateRepository extends MongoRepository<SalesAndTrafficByDate, String> {
//    @Query("{ 'date' : ?0 }")
    List<SalesAndTrafficByDate> findByDate(String date);

    @Query("{ 'date' : { $gt: ?0, $lt: ?1 } }")
    List<SalesAndTrafficByDate> findByDateRange(String startDate, String endDate);

//    https://www.baeldung.com/queries-in-spring-data-mongodb

    @Aggregation(pipeline = {
            "{ $group: { _id: \"$date\", totalSales: { $sum: \"$salesByDate.unitsOrdered\" }, totalTraffic: { $sum: \"$trafficByDate.visitors\" } } }"
    })
    List<Object> aggregateSalesAndTraffic();

}

