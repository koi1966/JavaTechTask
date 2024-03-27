package com.example.javatechtask.Servise;

import com.example.javatechtask.models.SalesAndTrafficByDate;
import com.example.javatechtask.models.repository.TrafficByDateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SumFromDate {

    private final TrafficByDateRepository trafficByDateRepository;
    private SalesAndTrafficByDate salesAndTrafficByDate;

    public SumFromDate(TrafficByDateRepository yourRepository) {
        this.trafficByDateRepository = yourRepository;
    }


        public void processDateRange(String startDate, String endDate) {
        List<SalesAndTrafficByDate> result = trafficByDateRepository.findByDateRange(startDate, endDate);

        double totalSales = 0;
        int totalUnitsOrdered = 0;
        int totalOrdersShipped = 0;
        // Другие переменные, которые вы хотите сложить

        for (SalesAndTrafficByDate entity : result) {
            totalSales += entity.getSalesByDate().getOrderedProductSales().getAmount();
            totalUnitsOrdered += entity.getSalesByDate().getUnitsOrdered();
            totalOrdersShipped += entity.getSalesByDate().getOrdersShipped();
            // Другие операции с данными
        }

        System.out.println("Общая сумма продаж: " + totalSales);
        System.out.println("Общее количество заказанных единиц: " + totalUnitsOrdered);
        System.out.println("Общее количество отгруженных заказов: " + totalOrdersShipped);
        // Другие выводы или операции с результатами
    }

}
