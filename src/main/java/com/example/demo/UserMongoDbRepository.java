package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoDbRepository extends MongoRepository<UserMongo,String> {
}
