package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Document(collection = "salesAndTrafficReports")
public class SalesAndTrafficReport {

    @Id
    private UUID id;

    private ReportSpecification reportSpecification;
    private List<SalesAndTrafficByDate> salesAndTrafficByDate;
    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;

    public SalesAndTrafficReport(UUID id, ReportSpecification reportSpecification, List<SalesAndTrafficByDate> salesAndTrafficByDate, List<SalesAndTrafficByAsin> salesAndTrafficByAsin) {

        this.id = id;
        this.reportSpecification = reportSpecification;
        this.salesAndTrafficByDate = salesAndTrafficByDate;
        this.salesAndTrafficByAsin = salesAndTrafficByAsin;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

