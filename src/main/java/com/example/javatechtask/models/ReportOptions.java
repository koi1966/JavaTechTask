package com.example.javatechtask.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;

//@Document(Collection = "report")
@Data
@Getter
@Setter
public class ReportOptions {

    private String dateGranularity;
    private String asinGranularity;

    // Constructors, getters, setters

}
