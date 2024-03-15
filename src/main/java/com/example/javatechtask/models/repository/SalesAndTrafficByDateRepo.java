package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.salesAndTrafficByDate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SalesAndTrafficByDateRepo extends MongoRepository<salesAndTrafficByDate, UUID> {


//    Salesandtrafficbydate findBySalesandtrafficbydate(String date);
}

