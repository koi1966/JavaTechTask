package com.example.javatechtask.controllers;

import com.example.javatechtask.servise.WriteFileJson;
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
        return writeFileJson.FineFromDate(date);
    }

}
