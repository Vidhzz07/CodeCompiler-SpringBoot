package com.example.ComplierModule.controller;


import com.example.ComplierModule.entities.CodeRequest;
import com.example.ComplierModule.entities.CodeResponse;
import com.example.ComplierModule.services.CompileCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noSave")
public class NoUserCompileController {



    @Autowired
    private CompileCodeService compileCodeService;


    @PostMapping("/execute")
    public ResponseEntity<CodeResponse> compileCode(@RequestBody CodeRequest codeRequest)
    {

        CodeResponse codeResponse = compileCodeService.compileCode(codeRequest);
        return ResponseEntity.ok(codeResponse);

    }

}
