package com.example.javatechtask.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Data
@JsonPOJOBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "reportSpecification")
public class ReportSpecification {
    public String reportType;
    public ReportOptions reportOptions;
    public String dataStartTime;
    public String dataEndTime;
    public ArrayList<String> marketplaceIds;
}
