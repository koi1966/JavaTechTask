package com.example.javatechtask.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportSpecification {
//    @Id
//    private UUID id;
private List<ReportSpecification> reportSpecifications;
    private String reportType;
    private ReportOptions reportOptions;
    private String dataStartTime;
    private String dataEndTime;
    private List<String> marketplaceIds;

}
