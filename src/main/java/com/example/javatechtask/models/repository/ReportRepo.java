package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.SalesAndTrafficReport;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ReportRepo extends MongoRepository<SalesAndTrafficReport, String> {
    SalesAndTrafficReport findBySalesAndTrafficByDate_Date(String date);
}

