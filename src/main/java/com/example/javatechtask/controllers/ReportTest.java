package com.example.javatechtask.controllers;


import com.example.javatechtask.Servise.WriteFileJson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/r")
@RequiredArgsConstructor
public class ReportTest {

    private final WriteFileJson writeFileJson;

    @GetMapping
    public ResponseEntity<String> getReportTest(@RequestParam("date") String date) {
        log.info("Search by this date - " + date);
        return writeFileJson.FileFromData(date);
    }

}
