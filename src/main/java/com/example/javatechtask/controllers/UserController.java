package com.example.javatechtask.controllers;

import com.example.javatechtask.models.User;
import com.example.javatechtask.models.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepo;

    @GetMapping("/all")
    public List<User> getAllUsersFromDB() {
        return userRepo.findAll();
    }

    @GetMapping
    public ResponseEntity<User> getUserByName(@RequestParam String name) {

        var user = userRepo.findByUsername(name);
        if (user == null) {
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(404))
                    .build();
        }
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public User putUserIntoDB(@RequestBody User user) {

        user.setId(UUID.randomUUID());

        return userRepo.save(user);
    }

    @GetMapping("/info")
    public String userData(Principal principal) {

        return principal.getName();
    }
}
