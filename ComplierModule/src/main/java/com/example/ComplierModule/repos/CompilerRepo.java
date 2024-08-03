package com.example.ComplierModule.repos;

import com.example.ComplierModule.entities.UserCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompilerRepo  extends MongoRepository<UserCode,String> {
}
