package com.example.javatechtask.Servise.arshiv;

import com.mongodb.MongoBulkWriteException;
import org.bson.Document;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
https://www.baeldung.com/java-import-json-mongodb
mongoimport --db=users --collection=contacts --file=contacts.json

mongoimport --db=newdb --collection=col --file=reportSpecification.json
mongoimport --db=newdb --collection=col --file=saleSandTrafficByDate.json
mongoimport --db=newdb --collection=col --file=salesAndTrafficByAsin.json

https://www.baeldung.com/java-generate-class-from-json
https://ru.stackoverflow.com/questions/1250930/%D0%9F%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D0%B8%D0%B7-json-%D0%B2-%D0%BE%D0%B1%D1%8A%D0%B5%D0%BA%D1%82-java

 */
@Service
public class ImportJsonService {

    private final MongoTemplate mongo;

    public ImportJsonService(MongoTemplate mongo) {
        this.mongo = mongo;
    }

    private List<Document> generateMongoDocs(List<String> lines) {
        List<Document> docs = new ArrayList<>();
        for (String json : lines) {
            docs.add(Document.parse(json));
        }
        return docs;
    }

    private int insertInto(String collection, List<Document> mongoDocs) {
        try {
            Collection<Document> inserts = mongo.insert(mongoDocs, collection);
            return inserts.size();
        } catch (DataIntegrityViolationException e) {
            if (e.getCause() instanceof MongoBulkWriteException) {
                return ((MongoBulkWriteException) e.getCause())
                        .getWriteResult()
                        .getInsertedCount();
            }
            return 0;
        }
    }

    //Finally, let’s combine those methods. This one takes the input and returns a string showing how many lines were read vs. successfully inserted:

    public String importTo(String collection, List<String> jsonLines) {
        List<Document> mongoDocs = generateMongoDocs(jsonLines);
        int inserts = insertInto(collection, mongoDocs);
        return inserts + "/" + jsonLines.size();
    }

    public static List<String> lines(String json) {
        String[] split = json.split("[\\r\\n]+");
        return Arrays.asList(split);
    }

}
