package com.example.javatechtask.controllers;


import com.example.javatechtask.models.User;
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
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportSpecific {
    private final ReportRepo reportRepo;

    @GetMapping("date")
    public ResponseEntity<ReportRepo> getReportByDate(@RequestParam String date) {

        var reports = reportRepo.findBySalesAndTrafficByDate_Date(date);
        if (reports == null) {
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(404))
                    .build();
        }
        return new ResponseEntity<>(reports, HttpStatusCode.valueOf(200));

    }
}
