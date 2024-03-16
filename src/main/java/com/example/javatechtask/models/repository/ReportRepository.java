package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.SalesAndTrafficReport;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;


public interface ReportRepository extends MongoRepository<SalesAndTrafficReport, UUID> {
    SalesAndTrafficReport findBySalesAndTrafficByDate_Date(String date);
}

