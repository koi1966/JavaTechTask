package com.example.javatechtask.Servise;

//import com.example.javatechtask.bd.MongoConfig;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

@Component
public class JsonToMongoDB {

//    private final MongoConfig mongoConfig;
//
//    public JsonToMongoDB(MongoConfig mongoConfig) {
//        this.mongoConfig = mongoConfig;
//    }

    public void JsToMoDB() {

        // Создание клиента MongoDB

//        MongoClient mongoClient = (MongoClient) MongoClients.create("mongodb://localhost:27017");

// Получение базы данных и коллекции
//        MongoDatabase database = mongoClient.getDatabase("newdb");
//        MongoCollection<Document> collection = database.getCollection("report");

    }
}
