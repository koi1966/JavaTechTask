package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SalesByAsin {
    public int unitsOrdered;
    public int unitsOrderedB2B;
    public OrderedProductSales orderedProductSales;
    public OrderedProductSalesB2B orderedProductSalesB2B;
    public int totalOrderItems;
    public int totalOrderItemsB2B;
}
