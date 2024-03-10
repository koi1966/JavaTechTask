package com.example.javatechtask.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "salesAndTrafficReports")
public class SalesAndTrafficReport {

    @Id
    private String id;

    private ReportSpecification reportSpecification;
    private List<SalesAndTrafficByDate> salesAndTrafficByDate;
    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;

    // Constructors, getters, setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ReportSpecification getReportSpecification() {
        return reportSpecification;
    }

    public void setReportSpecification(ReportSpecification reportSpecification) {
        this.reportSpecification = reportSpecification;
    }

    public List<SalesAndTrafficByDate> getSalesAndTrafficByDate() {
        return salesAndTrafficByDate;
    }

    public void setSalesAndTrafficByDate(List<SalesAndTrafficByDate> salesAndTrafficByDate) {
        this.salesAndTrafficByDate = salesAndTrafficByDate;
    }

    public List<SalesAndTrafficByAsin> getSalesAndTrafficByAsin() {
        return salesAndTrafficByAsin;
    }

    public void setSalesAndTrafficByAsin(List<SalesAndTrafficByAsin> salesAndTrafficByAsin) {
        this.salesAndTrafficByAsin = salesAndTrafficByAsin;
    }
}

