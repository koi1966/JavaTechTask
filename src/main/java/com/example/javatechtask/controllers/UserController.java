package com.example.javatechtask.controllers;

import com.example.javatechtask.models.User;

import com.example.javatechtask.models.repository.UserRepo;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepo userRepo;

    @GetMapping("/all")
    public List<User> getAllUsersFromDB(){
        return userRepo.findAll();
    }

    @GetMapping
    public ResponseEntity<User> getUserByName(@RequestParam String name){

        var user =userRepo.findByName(name);
        if (user == null) {
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(404))
                    .build();
        }
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public User putUserIntoDB(@RequestBody User user){

        user.setId(UUID.randomUUID());

        return userRepo.save(user);
    }


}
