package com.example.javatechtask.controllers;

import com.example.javatechtask.Servise.WriteFileJson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class ReportSpecific {

    private final WriteFileJson writeFileJson;

    @GetMapping
    public ResponseEntity<String> getReportByDate(@RequestParam("date") String date) {
        log.info("Search by this date - " + date);
        return writeFileJson.FileFromData(date);
    }

    @GetMapping("/between")
    public ResponseEntity<String> filterBetweenData(@RequestParam("firstDate") String firstDate,
                                                    @RequestParam("endDate") String endDate) {
        log.info("Search by between date - firstDate - " + firstDate +", endDate - "+ endDate);

//        return writeFileJson.calculateSumBetweenData(firstDate, endDate);
        return writeFileJson.filterBetweenDates(firstDate, endDate);
    }





}
