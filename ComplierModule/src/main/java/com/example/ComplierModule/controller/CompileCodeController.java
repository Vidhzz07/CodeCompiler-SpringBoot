package com.example.ComplierModule.controller;

import com.example.ComplierModule.entities.UserCode;
import com.example.ComplierModule.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.ComplierModule.entities.CodeRequest;
import com.example.ComplierModule.entities.CodeResponse;
import com.example.ComplierModule.services.CompileCodeService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/compile")
public class CompileCodeController {
	
	
	@Autowired
	private CompileCodeService compileCodeService;

	@Autowired
	private UserService userService;
	
	@PostMapping("/execute")
	public ResponseEntity<CodeResponse> compileCode(@RequestBody CodeRequest codeRequest)
	{
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		
		CodeResponse codeResponse = compileCodeService.compileCodeWithSave(codeRequest,userName);
		
		return ResponseEntity.ok(codeResponse);
	
	}

	@GetMapping("/getSavedCodes")
	public ResponseEntity<List<UserCode>> getUserSavedCodes()
	{
	Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
	String userName = authentication.getName();
		try{

			List<UserCode> savedCodes = userService.getUserSavedCodes(userName);
			return new ResponseEntity<>(savedCodes, HttpStatus.FOUND);
		}catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	@PostMapping("/executeFile")
	public ResponseEntity<String> compileFileCode(@RequestParam("file")MultipartFile file)
	{
		String script = compileCodeService.convertFileToCodeRequest(file);
		if (script!=null)
		{
			return  ResponseEntity.ok().body(script);
		}
		 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	

}
