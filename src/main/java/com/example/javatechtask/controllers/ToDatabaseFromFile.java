package com.example.javatechtask.controllers;

import com.example.javatechtask.models.User;
import com.example.javatechtask.models.salesAndTrafficByDate;
import com.example.javatechtask.models.repository.SalesAndTrafficByDateRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
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
    private final User user;

    public ToDatabaseFromFile(SalesAndTrafficByDateRepo salesAndTrafficByDateRepo, User user) {
        this.salesAndTrafficByDateRepo = salesAndTrafficByDateRepo;
        this.user = user;
    }


}


