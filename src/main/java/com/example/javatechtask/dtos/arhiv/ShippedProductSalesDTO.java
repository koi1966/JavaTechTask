package com.example.javatechtask.dtos.arhiv;

import lombok.Data;
import lombok.EqualsAndHashCode;


public record ShippedProductSalesDTO(
         double amount,
         String currencyCode
) {

}
