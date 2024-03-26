package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.SalesAndTrafficByDate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;


@EnableMongoRepositories
public interface TrafficByDateRepository extends MongoRepository<SalesAndTrafficByDate, String> {
    @Query("{ 'salesAndTrafficByDate.date' : ?0 }")
    List<SalesAndTrafficByDate> findSalesAndTrafficByDate(String date);

    @Query("{ 'date' : { $gt: ?0, $lt: ?1 } }")
    List<SalesAndTrafficByDate> findByDateRange(String startDate, String endDate);

//    https://www.baeldung.com/queries-in-spring-data-mongodb


}

