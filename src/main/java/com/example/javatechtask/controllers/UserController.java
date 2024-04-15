package com.example.javatechtask.controllers;

import com.example.javatechtask.servise.AppUser;
import com.example.javatechtask.models.User;
import com.example.javatechtask.models.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;
    private final AppUser appUser;

    public UserController(UserRepository userRepo, AppUser appUser) {
        this.userRepository = userRepo;
        this.appUser = appUser;
    }

    @GetMapping("/all")
    public List<User> getAllUsersFromDB() {
        return userRepository.findAll();
    }

//    @GetMapping
//    public ResponseEntity<User> getUserByName(@RequestParam String name) {
//
//        var user = userRepo.findByName(name);
//        if (user == null) {
//            return ResponseEntity
//                    .status(HttpStatusCode.valueOf(404))
//                    .build();
//        }
//        return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
//    }

    @PostMapping("/new-user")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addNewUserIntoDB(@RequestBody User user) {

        user.setId(UUID.randomUUID());
//        userRepo.save(user);
        appUser.addUser(user);
        return "New user is saved.";
    }

    @GetMapping("/user")
    public Optional<User> findUser(@RequestParam String username) {

        return appUser.findUser(username);
    }

}


//    @GetMapping
//    public ResponseEntity<User> getUserByName(@RequestParam String name) {
//
//        var user = userRepo.findByName(name);
//        if (user == null) {
//            return ResponseEntity
//                    .status(HttpStatusCode.valueOf(404))
//                    .build();
//        }
//        return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
//    }