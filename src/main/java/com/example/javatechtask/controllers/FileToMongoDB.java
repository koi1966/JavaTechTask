package com.example.javatechtask.controllers;

import com.example.javatechtask.Servise.JsonToMongoDB;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class FileToMongoDB {

    private final JsonToMongoDB jsonToMongoDB;

    public FileToMongoDB(JsonToMongoDB jsonToMongoDB) {
        this.jsonToMongoDB = jsonToMongoDB;
    }

    @GetMapping("/add")
    public String addJsonToMongoDB() {
        jsonToMongoDB.JsToMoDB();

        return "Add See html test !!!";
    }

    @PutMapping("/add")
    public String adJsonToMongoDB() {
        jsonToMongoDB.JsToMoDB();

        return "Add See html test !!!";
    }
}
