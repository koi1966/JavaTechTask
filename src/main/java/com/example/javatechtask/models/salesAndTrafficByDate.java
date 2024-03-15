package com.example.javatechtask.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Setter
@Getter
@Document
//@Document(collection = "SalesAndTrafficByDate")
public class salesAndTrafficByDate {

    @JsonIgnore
    @Id
    private UUID id;
    @JsonIgnore
    private String date;
    @JsonIgnore
    private SalesByDate salesByDate;
    @JsonIgnore
    private TrafficByDate trafficByDate;

}
