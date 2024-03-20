package com.example.javatechtask.bd;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    private static final String MONGO_URL = "mongodb://localhost:27017";

    @Override
    protected String getDatabaseName() {
        return "newdb";
    }

    @Override
//    public com.mongodb.client.MongoClient mongoClient() {
    public MongoClient mongoClient() {

        ConnectionString connectionString = new ConnectionString(MONGO_URL);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

}
