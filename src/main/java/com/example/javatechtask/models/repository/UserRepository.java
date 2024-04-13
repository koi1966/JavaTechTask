package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {
    Optional<User> findByName(String name);

//    GeoResults<User> findByLocationNear(Point location);
}
