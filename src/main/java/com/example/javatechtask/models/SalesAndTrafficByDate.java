package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class SalesAndTrafficByDate {
    @Id
    private ObjectId id;
    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
