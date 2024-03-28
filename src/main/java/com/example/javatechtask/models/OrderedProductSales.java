package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
public class OrderedProductSales {
    public double amount;
    public String currencyCode;

}
