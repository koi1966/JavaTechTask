package com.example.javatechtask.dtos;

import lombok.Data;
import lombok.Setter;


@Data
public class SalesAndTrafficByDateDTO {
    private String date;
    private SalesByDateDTO salesByDate;
    private TrafficByDateDTO trafficByDate;

}
