package com.example.javatechtask.bd;

import com.example.javatechtask.JavaTechTaskApplication;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

public class ConfigM {
    private static final String MONGO_URL = "mongodb://localhost:27017";
    public static MongoClient client ;
    public static MongoDatabase database ;
    public static MongoCollection<Document> collection;

    @Bean
    public MongoClient client() {
//        MongoClient client = new MongoClient(new MongoClientURI(MONGO_URL));
        return new MongoClient(new MongoClientURI(MONGO_URL));
    }

    @Bean
    public MongoDatabase database(){
        //    MongoDatabase database = client.getDatabase("person");

        return client.getDatabase("newdb");
    }

    @Bean
    public MongoCollection<Document> collection(){
        MongoCollection<Document> collection = database.getCollection("person");
        return collection;
    }

//    SpringApplication.run(JavaTechTaskApplication .class, args);

//    MongoClient client = new MongoClient(new MongoClientURI(MONGO_URL));
//    MongoDatabase database = client.getDatabase("person");
//    MongoCollection<Document> collection = database.getCollection("person");

}
