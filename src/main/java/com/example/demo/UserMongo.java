package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class UserMongo {
    private String id;
    private String name;
    String email;
    // constructors & setters & getters
}
