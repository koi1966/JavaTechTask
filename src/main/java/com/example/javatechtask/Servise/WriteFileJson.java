package com.example.javatechtask.Servise;

import com.example.javatechtask.models.SalesAndTrafficReport;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Slf4j
@Component
public class WriteFileJson {
    private final MongoTemplate mongoTemplate;


    public WriteFileJson(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public SalesAndTrafficReport WriteFileJsonPars() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        //Step 2: Add Jackson Dependency
// https://www.geeksforgeeks.org/how-to-read-and-write-json-files-in-java/?ref=ml_lbp
        SalesAndTrafficReport report = objectMapper.readValue(new File("src/main/resources/raznoe/test_report.json"),
                SalesAndTrafficReport.class);
//
        // Записать этот документ в коллекцию MongoDB
        return mongoTemplate.insert(report);
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
