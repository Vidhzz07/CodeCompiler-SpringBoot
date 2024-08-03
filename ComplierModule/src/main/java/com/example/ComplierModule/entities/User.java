package com.example.ComplierModule.entities;

import com.mongodb.lang.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document
public class User {
    @Id
    String id;
   @NonNull
           @Indexed(unique = true)
    String userName;
@NonNull
    String password;
    @DBRef
    List<UserCode> savedCodes = new ArrayList<>();

    List<String>roles;
}
