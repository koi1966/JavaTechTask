package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@EnableMongoRepositories
@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
//    User findByUsername(String name);

    Optional<User> findByUsername(String username);
}

