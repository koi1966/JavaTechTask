package com.example.javatechtask.Servise;

import com.example.javatechtask.models.OrderedProductSales;
import com.example.javatechtask.models.SalesAndTrafficByDate;
import com.example.javatechtask.models.SalesByDate;
import com.example.javatechtask.models.TrafficByDate;
import com.example.javatechtask.models.repository.TrafficByDateRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SumFromDate {

    private final TrafficByDateRepository trafficByDateRepository;

    public SumFromDate(TrafficByDateRepository yourRepository) {
        this.trafficByDateRepository = yourRepository;

    }

    public SalesAndTrafficByDate processDateRange(String startDate, String endDate) {

        List<SalesAndTrafficByDate> resultDates = trafficByDateRepository.findByDateRange(startDate, endDate);

        double totalSalesAmount = 0;
        int totalUnitsOrdered = 0;
        int totalOrdersShipped = 0;
        int totalPageViews = 0;
        int totalMobileAppPageViews = 0;
        String totalSalesCurrencyCode = "";
        // Другие переменные, которые вы хотите сложить

        for (SalesAndTrafficByDate entity : resultDates) {

            totalSalesAmount += entity.getSalesByDate().getOrderedProductSales().getAmount();
            totalSalesCurrencyCode = entity.getSalesByDate().getOrderedProductSales().getCurrencyCode();
            totalUnitsOrdered += entity.getSalesByDate().getUnitsOrdered();
            totalOrdersShipped += entity.getSalesByDate().getOrdersShipped();
            totalPageViews += entity.getTrafficByDate().getBrowserPageViews();
            totalMobileAppPageViews += entity.getTrafficByDate().getMobileAppPageViews();
            // Другие операции с данными
        }

        SalesAndTrafficByDate instance = new SalesAndTrafficByDate();
        // Устанавливаем значение для поля date
        instance.setDate("Sum between two dates " + startDate + " : " + endDate);

        // Создаем экземпляр класса SalesByDate
        SalesByDate salesByDate = new SalesByDate();

        // Создаем экземпляр класса OrderedProductSales
        OrderedProductSales productSales;
        productSales = new OrderedProductSales();
        productSales.setAmount(totalSalesAmount);
        productSales.setCurrencyCode(totalSalesCurrencyCode);

        // Устанавливаем значения для полей класса SalesByDate
        salesByDate.setUnitsOrdered(totalUnitsOrdered);
        salesByDate.setUnitsOrdered(totalOrdersShipped);

        //                  .getOrderedProductSales().setAmount(totalSales);
//                setSalesByDate.setOrderedProductSales().setAmount(totalSales);
//        result.getSalesByDate().getOrderedProductSales().setAmount(totalSales);
//        result.getSalesByDate().setUnitsOrdered(totalUnitsOrdered);
//        result.getSalesByDate().setOrdersShipped(totalOrdersShipped);
//        result.getSalesByDate().getOrderedProductSales().setAmount(totalSales);
//        result.getTrafficByDate().setBrowserPageViews(totalPageViews);
//        result.getTrafficByDate().setMobileAppPageViews(totalMobileAppPageViews);

        // Другие выводы или операции с результатами
        salesByDate.setOrderedProductSales(productSales);
// Устанавливаем объект SalesByDate в экземпляр класса SalesAndTrafficByDate
        instance.setSalesByDate(salesByDate);


        // Создаем экземпляр класса TrafficByDate
        TrafficByDate trafficByDate = new TrafficByDate();
        // Устанавливаем значения для полей класса TrafficByDate
        // (если они есть и они необходимы)

        // Устанавливаем объект TrafficByDate в экземпляр класса SalesAndTrafficByDate
        instance.setTrafficByDate(trafficByDate);

        // Теперь у вас есть экземпляр класса SalesAndTrafficByDate
        // с заполненными полями date, salesByDate и trafficByDate


        // Возвращаем список с одним элементом - объектом result
        return instance;
    }

}
