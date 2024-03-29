package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Setter
@Getter
@Document
public class User {

    @Id
    private UUID id;
    @Indexed(unique = true)
    private String name;
    private String password;
    private String email;
    private String roles;
    private boolean valid;

}

