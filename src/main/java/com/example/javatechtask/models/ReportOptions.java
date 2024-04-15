package com.example.javatechtask.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class ReportOptions {
    public String dateGranularity;
    public String asinGranularity;
}
