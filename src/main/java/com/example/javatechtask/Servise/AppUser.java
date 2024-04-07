package com.example.javatechtask.Servise;

import com.example.javatechtask.models.User;
import com.example.javatechtask.models.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppUser {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(User user){
        user.setId(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public Optional<User> findUser(@RequestParam String username) {

        return userRepository.findByName(username);
    }
}
