package com.example.javatechtask.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
public class AverageSalesPerOrderItemDTO{
    private double amount;
    private String currencyCode;
}
