package com.example.javatechtask.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@JsonPOJOBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "salesAndTrafficReport")
public class SalesAndTrafficReport {
    public ReportSpecification reportSpecification;
    public ArrayList<SalesAndTrafficByDate> salesAndTrafficByDate;
    public ArrayList<SalesAndTrafficByAsin> salesAndTrafficByAsin;
}
