package com.example.javatechtask.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;

@Data
@JsonPOJOBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TotalSaletByDateDTO {
    private String comment;
    private double totalOrderedProductSalesAmount;
    private double totalOrderedProductSalesB2B;
    private double totalUnitsOrdered;
    private double totalUnitsOrderedB2B;
    private double totalOrderItems;
    private double totalOrderItemsB2B;
    private double totalUnitsShipped;
    private double totalOrdersShipped;
    private double totalBrowserPageViews;
    private double totalBrowserPageViewsB2B;
    private double totalMobileAppPageViews;
    private double totalMobileAppPageViewsB2B;
    private double totalPageViews;
    private double totalPageViewsB2B;
    private double totalBrowserSessions;
    private double totalBrowserSessionsB2B;
    private double totalMobileAppSessions;
    private double totalMobileAppSessionsB2B;
    private double totalSessions;
    private double totalSessionsB2B;
}
