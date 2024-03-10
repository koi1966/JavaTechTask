package com.example.javatechtask.controllers;

import com.example.javatechtask.Servise.JsonToMongoDB;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FileToMongoDB {

    private final JsonToMongoDB jsonToMongoDB;
//    private final MongoDBExample mongoDBExample;

    // Lombok autowired - сам внедрил конструктор
//    public FileToMongoDB(JsonToMongoDB jsonToMongoDB) {
//        this.jsonToMongoDB = jsonToMongoDB;
//    }

    @GetMapping("/add")
    public String addJsonToMongoDB() {
//        jsonToMongoDB.JsMoDBTest();
        return "Add See html test 77777 !!! " + jsonToMongoDB.JsToMoDB();
    }

    @GetMapping("/a")
    public String addJson() {
        jsonToMongoDB.JsMoDBTest();
        return "Add See html test йй !!! " + jsonToMongoDB.JsToMoDB();
    }

    @GetMapping("/p")
    public String addPerson() {
        jsonToMongoDB.addPerson();
        return "Add See html test йй !!! " ;
    }

}
