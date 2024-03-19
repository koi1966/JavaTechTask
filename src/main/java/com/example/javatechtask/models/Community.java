package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@Document
public class Community {

    private List<ReportSpecification> reportSpecifications;

    private List<SalesAndTrafficByAsin> salesAndTrafficByAsins;
    private List<SalesAndTrafficByDate> salesAndTrafficByDates;

}
