package com.example.javatechtask.Servise;

import com.example.javatechtask.bd.MongoConfig;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class JsonToMongoDB {
    private final MongoTemplate mongoTemplate;
    private final MongoConfig mongoConfig;

    public JsonToMongoDB(MongoTemplate mongoTemplate, MongoConfig mongoConfig) {
        this.mongoTemplate = mongoTemplate;
        this.mongoConfig = mongoConfig;
    }

    public String JsToMoDB() {
mongoTemplate.getDb();
        boolean aga = mongoTemplate.collectionExists("users");
        System.out.println("+++++++++++++++"+ aga);

        MongoCollection<Document> collection = mongoTemplate.getCollection("users");
        // Пример запроса без использования сущности
        BasicDBObject query = new BasicDBObject("_id", "65e82f4800c3824bb814dfcd");
        // Выполнение запроса
        FindIterable<Document> result = collection.find(query);

        // Обработка результатов
        for (Document document : result) {
            System.out.println(" 4444444 " + document);
        }

        return "Collection test - 555";
    }

    public void JsMoDBTest(){
        MongoClient mongoClient = new MongoClient();
//        DB db = mongoClient.;
//        DBCollection coll = db.getCollection("users");
//        BasicDBObject query = new BasicDBObject("_id", "65e82f4800c3824bb814dfcd");

//        try (DBCursor cursor = coll.find(query)) {
//            while (cursor.hasNext()) {
//                System.out.println(cursor.next());
//            }
//        }
    }



}
