package com.example.javatechtask.Servise;

import com.example.javatechtask.models.User;
import com.example.javatechtask.models.repository.ReportRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class WriteFileJson {

    public static User user;
    public static ReportRepository reportRepository;
    public User WriteFileJsonPars(){

        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

        File file = new File("C:\\1\\SaleSandTrafficByDate.json");




        Object dataField = null;
        return reportRepository.save(dataField);
    }
}
