package com.example.javatechtask.Servise;

import com.example.javatechtask.models.Pojo;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
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

    }

    public void addPerson(){
//        MongoCollection<Document> collection1 = mongoTemplate.getCollection("report");
//        collection1.insertOne(new Document("money",6));
//
//        Document founded = collection1.find(new Document("money", 7)).first();
//        if (founded != null) {
//            System.out.println("ttyyuu - > " + founded.getString( "name"));
//        } else {
//            Document document = new Document("money", 7);
//            document.put("pririty","Житомир");
//            document.put("name","Oleg");
//            document.put("content","some extra plugins");
//            document.put("delta", Arrays.asList("mario","11.02.2018","lico","Nika",
//                    Arrays.asList("067","avto","null","some")));
//
//            collection1.insertOne(document); // add document from ..
//        }
//
//        collection1.updateOne(Filters.eq("money", 7), new Document(
//                "$set",
////                new Document("some field","some component") // creat new field
//                new Document("name","Nataly")  // edit this field "name" to a new value "Nataly"
//        ));
//
//        Pojo save = new Pojo(50, "test", Pojo.Role.STANDART);
        Pojo save = new Pojo(50, "test", Pojo.Role.STANDART);
        mongoTemplate.insert(save);

    }

}
