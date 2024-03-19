package com.example.javatechtask.controllers;

import com.example.javatechtask.Servise.WriteFileJson;
import com.example.javatechtask.models.Employee;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")

public class ToDatabaseFromFile {

    private final WriteFileJson writeFileJson;

    @PostMapping()
    public Employee addData() throws IOException {
        writeFileJson.WriteFileJsonPars();
        return null;
    }

}


