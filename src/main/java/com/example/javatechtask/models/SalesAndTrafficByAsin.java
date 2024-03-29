package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class SalesAndTrafficByAsin {
    public String parentAsin;
    public SalesByAsin salesByAsin;
    public TrafficByAsin trafficByAsin;
}
