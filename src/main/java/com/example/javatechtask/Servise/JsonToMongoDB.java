package com.example.javatechtask.Servise;

//import com.example.javatechtask.bd.MongoConfig;
import com.example.javatechtask.bd.MongoConfig;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class JsonToMongoDB {
    private final MongoTemplate mongoTemplate;


    public JsonToMongoDB(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;

    }

    public void JsToMoDB() {

        Boolean aga = mongoTemplate.collectionExists("report");
        System.out.println("+++++++++++++++"+ aga);
//        mongoTemplate.findById();
        // Создание клиента MongoDB

//        MongoClient mongoClient = (MongoClient) MongoClients.create("mongodb://localhost:27017");

// Получение базы данных и коллекции
//        MongoDatabase database = mongoClient.getDatabase("newdb");
//        MongoCollection<Document> collection = database.getCollection("report");

    }
}
