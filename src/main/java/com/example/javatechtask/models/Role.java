package com.example.javatechtask.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "roles")
public class Role {

    @Id
    private UUID id;

    private String name;
}
