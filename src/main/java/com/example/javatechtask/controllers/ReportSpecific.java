package com.example.javatechtask.controllers;

import com.example.javatechtask.Servise.WriteFileJson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class ReportSpecific {

    private final WriteFileJson writeFileJson;

    @GetMapping
    public String getReportByDate() {
        log.info("Search all by date ");
        return writeFileJson.FileFromData();
    }
}
