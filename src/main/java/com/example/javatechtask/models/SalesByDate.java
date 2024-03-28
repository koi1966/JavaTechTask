package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter

public class SalesByDate {
    public OrderedProductSales orderedProductSales;
    public OrderedProductSalesB2B orderedProductSalesB2B;
    public int unitsOrdered;
    public int unitsOrderedB2B;
    public int totalOrderItems;
    public int totalOrderItemsB2B;
    public AverageSalesPerOrderItem averageSalesPerOrderItem;
    public AverageSalesPerOrderItemB2B averageSalesPerOrderItemB2B;
    public double averageUnitsPerOrderItem;
    public double averageUnitsPerOrderItemB2B;
    public AverageSellingPrice averageSellingPrice;
    public AverageSellingPriceB2B averageSellingPriceB2B;
    public int unitsRefunded;
    public double refundRate;
    public int claimsGranted;
    public ClaimsAmount claimsAmount;
    public ShippedProductSales shippedProductSales;
    public int unitsShipped;
    public int ordersShipped;
}
