package com.example.javatechtask.dtos;

import com.example.javatechtask.models.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class SalesByDateDTO{
   private  OrderedProductSalesDTO orderedProductSales;
   private  OrderedProductSalesB2B orderedProductSalesB2B;
   private  int unitsOrdered;
   private  int unitsOrderedB2B;
   private  int totalOrderItems;
   private  int totalOrderItemsB2B;
   private  AverageSalesPerOrderItem averageSalesPerOrderItem;
   private  AverageSalesPerOrderItemB2B averageSalesPerOrderItemB2B;
   private  double averageUnitsPerOrderItem;
   private  double averageUnitsPerOrderItemB2B;
   private  AverageSellingPrice averageSellingPrice;
   private  AverageSellingPriceB2B averageSellingPriceB2B;
   private  int unitsRefunded;
   private  double refundRate;
   private  int claimsGranted;
   private  ClaimsAmount claimsAmount;
   private  ShippedProductSales shippedProductSales;
   private  int unitsShipped;
   private  int ordersShipped;



}
