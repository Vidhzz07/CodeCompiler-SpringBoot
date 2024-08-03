package com.example.ComplierModule.repos;

import com.example.ComplierModule.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User,String> {

    public User findByUserName(String username);
}
