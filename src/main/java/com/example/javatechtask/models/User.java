package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Document(collection = "users")
public class User {

    @Id
    private UUID id;
    @Indexed(unique = true)
    private String username;
    private String password;
    @Indexed(unique = true)
    private String email;
    @DBRef(lazy = true)
    private List<Role> roles;
    private boolean valid;

}

