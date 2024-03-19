package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class AverageSalesPerOrderItemB2B {

    private double amount;
    private String currencyCode;
}
