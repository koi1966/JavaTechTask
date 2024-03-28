package com.example.javatechtask.controllers;


//import com.example.javatechtask.models.repository.ReportRepository;

import com.example.javatechtask.Servise.SumFromDate;
import com.example.javatechtask.models.SalesAndTrafficByDate;
import com.example.javatechtask.models.repository.TrafficByDateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
//@RequiredArgsConstructor
@RequestMapping("/report")
public class Report {

    private final TrafficByDateRepository trafficByDateRepository;
    private final SumFromDate sumFromDate;

    public Report(TrafficByDateRepository trafficByDateRepository, SumFromDate sumFromDate) {
        this.trafficByDateRepository = trafficByDateRepository;
        this.sumFromDate = sumFromDate;
    }

    @GetMapping
    public List<SalesAndTrafficByDate> getReportOneDay(@RequestParam("date") String date) {
        log.info("Search by this date - " + date);

        return trafficByDateRepository.findByDate(date);
    }

    @GetMapping("/between")
    public List<SalesAndTrafficByDate> getReportBetweenDay(@RequestParam("startDate") String startDate,
                                                           @RequestParam("endDate") String endDate) {

        log.info("Search by this date - " + startDate + " " + endDate);

        List<SalesAndTrafficByDate> result = trafficByDateRepository.findByDateRange(startDate, endDate);

        return result;
    }

    @GetMapping("/sum")
    public List<SalesAndTrafficByDate> getReportBetweenDaySum(@RequestParam("startDate") String startDate,
                                                              @RequestParam("endDate") String endDate) {

        log.info("Search by this date and sum - " + startDate + " " + endDate);

        return sumFromDate.processDateRange(startDate, endDate);
    }

}
