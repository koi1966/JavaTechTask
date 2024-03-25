package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.SalesAndTrafficByDate;
import com.example.javatechtask.models.SalesAndTrafficReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;


@EnableMongoRepositories
public interface TrafficByDateRepository extends MongoRepository<SalesAndTrafficByDate, String> {
//    @Query("{ 'salesAndTrafficByDate.date' : ?0 }")
//    List<SalesAndTrafficReport> findSalesAndTrafficReportsBySalesAndTrafficByDate(String date);
//    List<SalesAndTrafficByDate> findSalesAndTrafficByDateByAndDate(String date);
    List<SalesAndTrafficByDate> findSalesAndTrafficByDate(String date);

//    @Query("{ 'salesAndTrafficByDate.date' : ?0 }")
//    List<SalesAndTrafficByDate> findSalesAndTrafficByDateBetween(String dateFirst, String dateEnd );
@Query("{ 'date' : { $gt: ?0, $lt: ?1 } }")
    List<SalesAndTrafficByDate> findSalesAndTrafficByDateBetween(String date, String date2 );

//    https://www.baeldung.com/queries-in-spring-data-mongodb
}

