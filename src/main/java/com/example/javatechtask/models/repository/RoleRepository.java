package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@EnableMongoRepositories
@Repository
public interface RoleRepository extends MongoRepository<Role, UUID> {
    Optional<Role> findByName(String name);

}
