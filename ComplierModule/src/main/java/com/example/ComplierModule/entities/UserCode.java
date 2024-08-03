package com.example.ComplierModule.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class UserCode {

    @Id
    String id;

    String script;

    String date;

    String language;

    String memory;

    String output;

    String timeOfExecution;

    boolean successfulCompilation =true;


}
