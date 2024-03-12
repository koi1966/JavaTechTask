package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepo extends MongoRepository<User, UUID> {
    User findByName(String name);
}
