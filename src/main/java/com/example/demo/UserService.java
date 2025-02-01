package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMongoDbRepository userMongoDbRepository;
//    @Autowired
//    private  userSqlRepo userSqlRepo;
    public List<UserMongo> getAllMongoUsers(){
        return userMongoDbRepository.findall();
    }


}
