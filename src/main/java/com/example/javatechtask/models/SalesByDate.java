package com.example.javatechtask.models;

import lombok.Data;

//@Data
public class SalesByDate {
    private OrderedProductSales orderedProductSales;
    private OrderedProductSalesB2B orderedProductSalesB2B;
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
    private AverageSalesPerOrderItem averageSalesPerOrderItem;
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
