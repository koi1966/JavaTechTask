package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.User;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {
    User findByName(String name);

//    GeoResults<User> findByLocationNear(Point location);
}
