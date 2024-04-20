package com.example.javatechtask.dtos.arhiv;

import lombok.Data;
import lombok.EqualsAndHashCode;

public record AverageSellingPriceDTO(
        double amount,
        String currencyCode
) {

}
