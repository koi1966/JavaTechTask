package com.example.javatechtask.controllers;

import com.example.javatechtask.Servise.AppUser;
import com.example.javatechtask.models.User;
import com.example.javatechtask.models.repository.UserRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepo;
    private final AppUser appUser;

    public UserController(UserRepository userRepo, AppUser appUser) {
        this.userRepo = userRepo;
        this.appUser = appUser;
    }

    @GetMapping("/all")
    public List<User> getAllUsersFromDB() {
        return userRepo.findAll();
    }

    @GetMapping
    public ResponseEntity<User> getUserByName(@RequestParam String name) {

        var user = userRepo.findByName(name);
        if (user == null) {
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(404))
                    .build();
        }
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/new-user")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    public String addNewUserIntoDB(@RequestBody User user) {

        user.setId(UUID.randomUUID());
//        userRepo.save(user);
        appUser.addUser(user);
        return "New user is saved.";
    }

}
