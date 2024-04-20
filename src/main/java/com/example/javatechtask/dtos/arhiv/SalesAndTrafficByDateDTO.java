package com.example.javatechtask.dtos.arhiv;

import lombok.Data;



public class SalesAndTrafficByDateDTO {
    private String date;
    private SalesByDateDTO salesByDate;
    private TrafficByDateDTO trafficByDate;
}
