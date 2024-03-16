package com.example.javatechtask.controllers;

import com.example.javatechtask.models.repository.SalesAndTrafficByDateRepo;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/file")
//@RequiredArgsConstructor
public class ToDatabaseFromFile {

    private final SalesAndTrafficByDateRepo salesAndTrafficByDateRepo;


    public ToDatabaseFromFile(SalesAndTrafficByDateRepo salesAndTrafficByDateRepo) {
        this.salesAndTrafficByDateRepo = salesAndTrafficByDateRepo;

    }


}


