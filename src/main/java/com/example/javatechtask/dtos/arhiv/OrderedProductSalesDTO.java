package com.example.javatechtask.dtos.arhiv;

import lombok.Data;
import lombok.EqualsAndHashCode;


public record OrderedProductSalesDTO(
        double amount,
        String currencyCode
) {
}
