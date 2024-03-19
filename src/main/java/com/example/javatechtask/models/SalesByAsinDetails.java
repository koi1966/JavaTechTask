package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class SalesByAsinDetails {
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private OrderedProductSales orderedProductSales;

}
