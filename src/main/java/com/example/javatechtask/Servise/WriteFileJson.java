package com.example.javatechtask.Servise;

import com.example.javatechtask.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class WriteFileJson {

    public static User addDataFromFile;

    public void WriteFileJsonPars(){

        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

        File file = new File("C:\\1\\SaleSandTrafficByDate.json");


    }
}
