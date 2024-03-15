package com.example.javatechtask.controllers;

import com.example.javatechtask.models.salesAndTrafficByDate;
import com.example.javatechtask.models.repository.SalesAndTrafficByDateRepo;
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
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportSpecific {
    private final SalesAndTrafficByDateRepo salesAndTrafficByDateRepo;

    @GetMapping("/date")
    public ResponseEntity<salesAndTrafficByDate> getReportByDate(@RequestParam String date) {

        salesAndTrafficByDate reports = null;// reportRepo.findBySalesandtrafficbydate(date);

        if (reports == null) {
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(404))
                    .build();
        }
        return new ResponseEntity<>(reports, HttpStatusCode.valueOf(200));

    }
}
