package com.example.javatechtask.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class ReportOptions {
    private String dateGranularity;
    private String asinGranularity;
}
