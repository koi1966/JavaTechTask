package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.SalesAndTrafficReport;
import com.example.javatechtask.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<SalesAndTrafficReport, String> {
    SalesAndTrafficReport findBy(String name);
//    https://www.baeldung.com/queries-in-spring-data-mongodb
}
