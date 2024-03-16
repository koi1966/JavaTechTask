package com.example.javatechtask.controllers;

import com.example.javatechtask.Servise.JsonToMongoDB;
import com.example.javatechtask.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileToMongoDB {

    private final JsonToMongoDB jsonToMongoDB;


    @GetMapping("/add")
    public String addJsonToMongoDB() {
//        jsonToMongoDB.JsMoDBTest();
        return "Add See html test 77777 !!! " + jsonToMongoDB.JsToMoDB();
    }

    @PostMapping
    public User addJsonFileToMongoDB(){

//        user.setId(UUID.randomUUID());

        return jsonToMongoDB.addFile();
    }

    @GetMapping("/p")
    public String addPerson() {
        jsonToMongoDB.addPerson();
        return "Add See html test йй !!! " ;
    }

}
