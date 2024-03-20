package com.example.javatechtask.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Setter
@Getter
@Document
public class SalesAndTrafficReport {
    public ReportSpecification reportSpecification;
    public ArrayList<SalesAndTrafficByDate> salesAndTrafficByDate;
    public ArrayList<SalesAndTrafficByAsin> salesAndTrafficByAsin;
}
