package com.example.javatechtask;


import com.example.javatechtask.bd.MongoConfig;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaTechTaskApplication {
//    private static final String MONGO_URL = "mongodb://localhost:27017";

    public static void main(String[] args) {

//        MongoClient client = new MongoClient(new MongoClientURI(MONGO_URL));
        SpringApplication.run(JavaTechTaskApplication.class, args);
//        MongoDatabase database = client.getDatabase("person");
//        MongoCollection<Document> collection = database.getCollection("person");

//        System.out.println("Connected !!!");

//        collection.insertOne(new Document("money",6));
    }

}
