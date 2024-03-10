package com.example.javatechtask.bd;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "newdb";
    }


    @Override
    public MongoClient mongoClient() {

        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }
//            MongoDatabase database = mongoClient.getDatabase("newdb")//;
//          MongoCollection<Document> collection = database.getCollection("users");

//        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
//            MongoDatabase database = mongoClient.getDatabase("newdb");
//            MongoCollection<Document> collection = database.getCollection("users");
//
//            // Ваши операции с MongoDB
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
}
