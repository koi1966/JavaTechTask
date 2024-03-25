package com.example.javatechtask.controllers;


import com.example.javatechtask.Servise.WriteFileJson;
//import com.example.javatechtask.models.repository.ReportRepository;
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
@RequestMapping("/r")
public class ReportTest {

    private final TrafficByDateRepository trafficByDateRepository;
    private final WriteFileJson writeFileJson;

    public ReportTest(TrafficByDateRepository trafficByDateRepository, WriteFileJson writeFileJson) {
        this.trafficByDateRepository = trafficByDateRepository;
        this.writeFileJson = writeFileJson;
    }

    @GetMapping
    public List<SalesAndTrafficByDate> getReportTest(@RequestParam("dateF") String dateF,@RequestParam("dateN") String dateN) {
        log.info("Search by this date - " + dateF + " " + dateN);
        List<SalesAndTrafficByDate> report = trafficByDateRepository.
        findSalesAndTrafficByDateBetween(dateF,dateN);
        return report;
    }

}
