package com.example.javatechtask.controllers;

import com.example.javatechtask.Servise.JsonToMongoDB;
import com.example.javatechtask.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileToMongoDB {

    private final JsonToMongoDB jsonToMongoDB;

    @GetMapping("/find")
    public String addJsonToMongoDB() {

        return "Add See html test 77777 !!! " + jsonToMongoDB.JsToMoDB();
    }

    @GetMapping("/p")
    public String addPerson() {
        jsonToMongoDB.addPerson();
        return "Add See html test йй !!! " ;
    }

}
