package com.example.javatechtask.Servise;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class JsonToMongoDB {
    private final MongoTemplate mongoTemplate;

    public JsonToMongoDB(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public String JsToMoDB() {
        mongoTemplate.getDb();
        boolean aga = mongoTemplate.collectionExists("report");
        System.out.println("+++++++++++++++" + aga);

        MongoCollection<Document> collection = mongoTemplate.getCollection("report");
        // Пример запроса без использования сущности
//        BasicDBObject query = new BasicDBObject("city", "New York");
        BasicDBObject query = new BasicDBObject("reportSpecification.dataStartTime", "2024-02-14");
        // Выполнение запроса
        FindIterable<Document> result = collection.find(query);

        // Обработка результатов
        for (Document document : result) {
            System.out.println(" 4444444 --> " + document);
        }

        return "Collection test - 555" ;
    }

    public void JsMoDBTest() {
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
