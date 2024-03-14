package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SalesAndTrafficByDate {
    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
