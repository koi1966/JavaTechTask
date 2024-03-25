package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Setter
@Getter
@Document
@EnableMongoRepositories
public class SalesAndTrafficByDate {
    public String date;
    public SalesByDate salesByDate;
    public TrafficByDate trafficByDate;
}
