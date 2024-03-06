package com.example.javatechtask.bd;

import org.springframework.stereotype.Component;

import java.sql.Connection;

@Component
public class ConnectMongoDB {
    private static final String URL = "jdbc:jtds:sybase://zhytomyr:5000/gai";
    private static final String USERNAME = "view_user";
    private static final String PASSWORD = "view_user";

    private Connection connectionSa;

}
