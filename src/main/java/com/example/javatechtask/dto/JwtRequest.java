package com.example.javatechtask.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
