package com.example.javatechtask.Servise;



import com.example.javatechtask.bd.MongoConfig;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import static com.mongodb.client.model.Filters.*;


@Component
public class JsonToMongoDB {

    private final MongoTemplate mongoTemplate;

    public JsonToMongoDB(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public String JsToMoDB() {
        mongoTemplate.getDb();
        boolean aga = mongoTemplate.collectionExists("report");
        System.out.println("+++++++++++++++"+ aga);

        MongoCollection<Document> collection = mongoTemplate.getCollection("report");

        Document query = new Document("reportType", "GET_SALES_AND_TRAFFIC_REPORT");
        FindIterable<Document> cursor = collection.find(query);

        for (Document document : cursor) {
            System.out.println(document);
        }


//        // Пример запроса без использования сущности
        BasicDBObject query = new BasicDBObject("_id","65ea1142eae39acce0a00448");
//        // Выполнение запроса
//        FindIterable<Document> result = collection.find(query);
//
//        // Обработка результатов
//        for (Document document : result) {
//            System.out.println(" 4444444 " + document);
//        }
//
//        DBCollection db


        return "Collection test - 555";
    }

    public void JsMoDBTest(){
//        MongoClient client = new MongoConfig().mongoClient();
//        MongoDatabase database = client.getDatabase("mydb");
        MongoCollection<Document> collection = mongoTemplate.getCollection("report");
        Document myDoc = collection.find(eq("date", "2024-02-14")).first();
        System.out.println(myDoc.toJson());
    }



}
