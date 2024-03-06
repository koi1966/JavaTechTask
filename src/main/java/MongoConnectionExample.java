import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoConnectionExample {

    public static void main(String[] args) {
//        try (MongoClient mongoClient = new MongoClient ("localhost", 27017)) {
        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
            MongoDatabase database = mongoClient.getDatabase("newdb");
            MongoCollection<Document> collection = database.getCollection("users");

            // Ваши операции с MongoDB
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

