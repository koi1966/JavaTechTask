package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.SalesAndTrafficReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.UUID;


public interface ReportRepo extends MongoRepository<SalesAndTrafficReport, UUID> {
    SalesAndTrafficReport findByReportSpecificationDataStartTime(String date);

    SalesAndTrafficReport findBySalesAndTrafficByDateDate(String date);
}

