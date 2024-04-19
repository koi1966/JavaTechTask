package com.example.javatechtask.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public record AverageSalesPerOrderItemDTO(
        double amount,
        String currencyCode
) {

}
