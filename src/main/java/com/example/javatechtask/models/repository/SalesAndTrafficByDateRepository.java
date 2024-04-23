package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.SalesAndTrafficByDate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableMongoRepositories
@Repository
public interface SalesAndTrafficByDateRepository extends MongoRepository<SalesAndTrafficByDate, String> {

    List<SalesAndTrafficByDate> findByDateBetween(String startDate, String endDate);
}
