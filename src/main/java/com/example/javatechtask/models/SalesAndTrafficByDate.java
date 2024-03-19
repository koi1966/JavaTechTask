package com.example.javatechtask.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@Document
//@Document(collection = "SalesAndTrafficByDate")
public class SalesAndTrafficByDate {

//    @JsonIgnore
//    @Id
//    private UUID id;
//    private String date;
//    private SalesByDate salesByDate;
//    private TrafficByDate trafficByDate;

    //    private List<SalesAndTrafficByDate> salesAndTrafficByDate;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String date;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private SalesByDate salesByDate;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private TrafficByDate trafficByDate;
//    public List<SalesAndTrafficByDate> getSalesAndTrafficByDate() {
//        return salesAndTrafficByDate;
//        }

}

