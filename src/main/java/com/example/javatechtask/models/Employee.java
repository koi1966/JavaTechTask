package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Setter
@Getter
@Document
public class Employee {
//    @Id
//    private UUID id;
    private String firstName;
    private String lastName;
    private int age;

}
