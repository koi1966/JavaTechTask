package com.example.javatechtask.dtos.arhiv;

import lombok.Data;
import lombok.EqualsAndHashCode;


public record ClaimsAmountDTO(
         int amount,
         String currencyCode
) {

}
