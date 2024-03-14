package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SalesAndTrafficByAsin {

    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;
}
