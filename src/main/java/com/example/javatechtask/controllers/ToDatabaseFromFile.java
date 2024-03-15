package com.example.javatechtask.controllers;

import com.example.javatechtask.models.salesAndTrafficByDate;
import com.example.javatechtask.models.repository.SalesAndTrafficByDateRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Getter
@RestController
@RequestMapping("/file")
//@RequiredArgsConstructor
public class ToDatabaseFromFile {

    private final SalesAndTrafficByDateRepo salesAndTrafficByDateRepo;

    public ToDatabaseFromFile(SalesAndTrafficByDateRepo salesAndTrafficByDateRepo) {
        this.salesAndTrafficByDateRepo = salesAndTrafficByDateRepo;
    }

    @PostMapping
    public salesAndTrafficByDate putFileIntoDB() {


        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

        File file = new File("C:\\1\\SaleSandTrafficByDate.json");
        salesAndTrafficByDate DateJson = null;

        {
            try {
                 DateJson = objectMapper.readValue(file, salesAndTrafficByDate.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        DateJson.setId(UUID.randomUUID());

        return salesAndTrafficByDateRepo.save(DateJson);
    }


}


