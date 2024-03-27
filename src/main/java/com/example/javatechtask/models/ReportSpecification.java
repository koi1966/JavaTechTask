package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Setter
@Getter
public class ReportSpecification {
    public String reportType;
    public ReportOptions reportOptions;
    public String dataStartTime;
    public String dataEndTime;
    public ArrayList<String> marketplaceIds;
}
