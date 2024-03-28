package com.example.javatechtask.Servise;

import com.example.javatechtask.models.SalesAndTrafficByDate;
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

    public List<SalesAndTrafficByDate> processDateRange(String startDate, String endDate) {
        List<SalesAndTrafficByDate> resultDates = trafficByDateRepository.findByDateRange(startDate, endDate);

        double totalSales = 0;
        int totalUnitsOrdered = 0;
        int totalOrdersShipped = 0;
        int totalPageViews = 0;
        int totalMobileAppPageViews = 0;
        // Другие переменные, которые вы хотите сложить

//        SalesAndTrafficByDate result = new SalesAndTrafficByDate();
        List<SalesAndTrafficByDate> result = new ArrayList<>();

        for (SalesAndTrafficByDate entity : resultDates) {

            totalSales += entity.getSalesByDate().getOrderedProductSales().getAmount();
            totalUnitsOrdered += entity.getSalesByDate().getUnitsOrdered();
            totalOrdersShipped += entity.getSalesByDate().getOrdersShipped();
            totalPageViews += entity.getTrafficByDate().getBrowserPageViews();
            totalMobileAppPageViews += entity.getTrafficByDate().getMobileAppPageViews();
            // Другие операции с данными
        }
        result.set()setSalesByDate();
        result.get()SalesByDate().getOrderedProductSales().setAmount(totalSales);
//                  .getOrderedProductSales().setAmount(totalSales);
//                setSalesByDate.setOrderedProductSales().setAmount(totalSales);
//        result.getSalesByDate().getOrderedProductSales().setAmount(totalSales);
//        result.getSalesByDate().setUnitsOrdered(totalUnitsOrdered);
//        result.getSalesByDate().setOrdersShipped(totalOrdersShipped);
//        result.getSalesByDate().getOrderedProductSales().setAmount(totalSales);
//        result.getTrafficByDate().setBrowserPageViews(totalPageViews);
//        result.getTrafficByDate().setMobileAppPageViews(totalMobileAppPageViews);

        // Другие выводы или операции с результатами

// Создаем список для возврата результата
        List<SalesAndTrafficByDate> resultList = new ArrayList<>();
        // Добавляем объект result в список
        resultList.add(result);

        // Возвращаем список с одним элементом - объектом result
        return resultList;
    }

}
