package com.example.javatechtask.controllers;

import com.example.javatechtask.Servise.WriteFileJson;
import com.example.javatechtask.models.Employee;
import com.example.javatechtask.models.SalesAndTrafficReport;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class ToDatabaseFromFile {

    private final WriteFileJson writeFileJson;

    @PostMapping()
    public SalesAndTrafficReport addData() throws IOException {
        log.info("Get request to write to db from file");
        SalesAndTrafficReport report = writeFileJson.WriteFileJsonPars();
        log.info("Данные успешно записаны в MongoDB.");
        return report;
    }

}


