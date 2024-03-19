package com.example.javatechtask.Servise;

import com.example.javatechtask.models.*;
import com.example.javatechtask.models.repository.EmployeeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class WriteFileJson {
    public static User user;
    public static Employee employee;
    private final MongoTemplate mongoTemplate;
    private final EmployeeRepository employeeRepository;

    public WriteFileJson(MongoTemplate mongoTemplate, EmployeeRepository employeeRepository) {
        this.mongoTemplate = mongoTemplate;
        this.employeeRepository = employeeRepository;
    }
    public void WriteFileJsonPars() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();//.findAndRegisterModules();


//        MongoCollection<Document> collection = mongoTemplate.getCollection("report11");
        MongoCollection<Document> collection = mongoTemplate.createCollection(ReportSpecification.class);
//        MongoCollection<Document> collection = mongoTemplate.getCollection("report11");

        //Step 2: Add Jackson Dependency
// https://www.geeksforgeeks.org/how-to-read-and-write-json-files-in-java/?ref=ml_lbp
        JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/raznoe/test_report.json"));

//        File file = new File("c:\\1\\test_report.json");
        File file = new File("src/main/resources/raznoe/test_report.json");

//        try {
            // Прочитать данные из JSON-файла в список объектов Employee
//            List<Employee> employeeList = objectMapper.readValue(file, new TypeReference<List<Employee>>() {});
//            SalesAndTrafficByDate employeeList = objectMapper.readValue(file, new TypeReference<>() {});
            // Создать один документ, содержащий весь список объектов Employee
            Document document = new Document();
            document.append("report55", jsonNode);

            // Записать этот документ в коллекцию MongoDB
            collection.insertOne(document);

            System.out.println("Данные успешно записаны в MongoDB.");

//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}


//        File file = new File("c:\\1\\employee2.json");
//                employee = objectMapper.readValue(file, Employee.class);
//       List<Employee> employeeList = objectMapper.readValue(file, new TypeReference<List<Employee>>() {});
//        document.insertMany((ClientSession) employeeList, (List<? extends Document>) document);
//        employee.setId(UUID.randomUUID());
//        employeeRepository.save(employee);

// Преобразовать список объектов Employee в список документов
//        List<Document> documents = employeeList.stream()
//                .map(employee -> new Document()
//                        .append("firstName", employee.getFirstName())
//                        .append("lastName", employee.getLastName())
//                        .append("age", employee.getAge()))
//                .toList();
//
//        // Записать список документов в коллекцию MongoDB
//        collection.insertMany(documents);

// Зарегистрируем кодек для класса Employee
