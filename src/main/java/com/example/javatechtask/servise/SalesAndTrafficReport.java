package com.example.javatechtask.servise;

import com.example.javatechtask.models.SalesAndTrafficByDate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesAndTrafficReport {

    private final ArrayList<SalesAndTrafficByDate> salesAndTrafficByDate;

    public SalesAndTrafficReport(ArrayList<SalesAndTrafficByDate> salesAndTrafficByDate) {
        this.salesAndTrafficByDate = salesAndTrafficByDate;
    }

    public SalesAndTrafficByDate findSalesAndTrafficByDate(String date) {

        for (SalesAndTrafficByDate entry : salesAndTrafficByDate) {
            if (entry.getDate().equals(date)) {
                return entry;
            }
        }
        return null; // Если запись не найдена
    }
}
