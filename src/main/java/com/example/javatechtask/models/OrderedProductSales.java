package com.example.javatechtask.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class OrderedProductSales {
    private double amount;
    private String currencyCode;
}
