package com.example.javatechtask.apikey;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//@Document
//@Table(name = "api_keys")
public class ApiKeyEntity {
    @Id
    private String apiKey;

//    @Enumerated(EnumType.STRING)
//    @Column(columnDefinition = "status_type")
//    @Type(PostgreSQLEnumType.class)
//    private ClientStatus status;

//    private String client;
}
