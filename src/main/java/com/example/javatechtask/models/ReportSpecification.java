package com.example.javatechtask.models;

import lombok.Data;

import java.util.List;

@Data
public class ReportSpecification {

    private String reportType;
    private ReportOptions reportOptions;
    private String dataStartTime;
    private String dataEndTime;
    private List<String> marketplaceIds;

    // Constructors, getters, setters

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public ReportOptions getReportOptions() {
        return reportOptions;
    }

    public void setReportOptions(ReportOptions reportOptions) {
        this.reportOptions = reportOptions;
    }

    public String getDataStartTime() {
        return dataStartTime;
    }

    public void setDataStartTime(String dataStartTime) {
        this.dataStartTime = dataStartTime;
    }

    public String getDataEndTime() {
        return dataEndTime;
    }

    public void setDataEndTime(String dataEndTime) {
        this.dataEndTime = dataEndTime;
    }

    public List<String> getMarketplaceIds() {
        return marketplaceIds;
    }

    public void setMarketplaceIds(List<String> marketplaceIds) {
        this.marketplaceIds = marketplaceIds;
    }
}
