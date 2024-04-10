package com.example.javatechtask.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Employee {
//    @Id
//    private UUID id;
    private String firstName;
    private String lastName;
    private int age;

}
