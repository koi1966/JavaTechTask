package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class SalesByAsin {
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private OrderedProductSales orderedProductSales;
    private OrderedProductSalesB2B orderedProductSalesB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;

}
