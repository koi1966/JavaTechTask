package com.example.javatechtask.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public record AverageSalesPerOrderItemB2BDTO(
        double amount,
        String currencyCode
) {
}