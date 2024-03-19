package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class AverageSalesPerOrderItem {
    private double amount;
    private String currencyCode;
}
