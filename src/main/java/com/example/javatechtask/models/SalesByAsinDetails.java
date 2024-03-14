package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesByAsinDetails {
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private OrderedProductSales orderedProductSales;

}
