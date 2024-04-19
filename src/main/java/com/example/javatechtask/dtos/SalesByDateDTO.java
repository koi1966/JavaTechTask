package com.example.javatechtask.dtos;

import com.example.javatechtask.models.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public record SalesByDateDTO(
        OrderedProductSales orderedProductSales,
        OrderedProductSalesB2B orderedProductSalesB2B,
        int unitsOrdered,
        int unitsOrderedB2B,
        int totalOrderItems,
        int totalOrderItemsB2B,
        AverageSalesPerOrderItem averageSalesPerOrderItem,
        AverageSalesPerOrderItemB2B averageSalesPerOrderItemB2B,
        double averageUnitsPerOrderItem,
        double averageUnitsPerOrderItemB2B,
        AverageSellingPrice averageSellingPrice,
        AverageSellingPriceB2B averageSellingPriceB2B,
        int unitsRefunded,
        double refundRate,
        int claimsGranted,
        ClaimsAmount claimsAmount,
        ShippedProductSales shippedProductSales,
        int unitsShipped,
        int ordersShipped
) {
}
