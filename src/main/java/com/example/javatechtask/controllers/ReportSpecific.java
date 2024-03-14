package com.example.javatechtask.controllers;

import com.example.javatechtask.models.SalesAndTrafficReport;
import com.example.javatechtask.models.repository.ReportRepo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/r")
@RequiredArgsConstructor
public class ReportSpecific {
    private final ReportRepo reportRepo;

    @GetMapping("/d")
    public ResponseEntity<SalesAndTrafficReport> getReportByDate(@RequestParam String date) {

//        SalesAndTrafficReport reports = reportRepo.findByReportSpecificationDataStartTime(date);
        SalesAndTrafficReport reports = reportRepo.findBySalesAndTrafficByDateDate(date);
        if (reports == null) {
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(404))
                    .build();
        }
        return new ResponseEntity<>(reports, HttpStatusCode.valueOf(200));

    }
}
