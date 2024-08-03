package com.example.ComplierModule.services;


import com.example.ComplierModule.entities.User;
import com.example.ComplierModule.entities.UserCode;
import com.example.ComplierModule.repos.CompilerRepo;
import com.example.ComplierModule.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ComplierModule.entities.CodeRequest;
import com.example.ComplierModule.entities.CodeResponse;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;


@Service
public class CompileCodeService {
	

private	String clientId = "###############"; // Replace with your client ID
private    String clientSecret = "###########"; //Replace with your clientSecret

private String executeCodeAPIURL = "https://api.jdoodle.com/v1/execute";


private RestTemplate restTemplate = new RestTemplate();


@Autowired
private CompilerRepo compilerRepo;

@Autowired
private UserRepo userRepo;


@Autowired
private UserService userService;
    

	
	public CodeResponse compileCodeWithSave(CodeRequest codeRequest,String userName)
	{
		codeRequest.setClientId(clientId);
		codeRequest.setClientSecret(clientSecret);
		
		
		HttpEntity<CodeRequest> httpEntity = new HttpEntity<CodeRequest>(codeRequest);
		
		ResponseEntity<CodeResponse> responseEntity = restTemplate.postForEntity(executeCodeAPIURL, codeRequest, CodeResponse.class);

	  UserCode userCode	= saveUserCode(codeRequest,responseEntity.getBody());
	  User user = userService.getUser(userName);
	  List<UserCode> list = user.getSavedCodes();
	  list.add(userCode);
	  userRepo.save(user);

		return responseEntity.getBody();
	}

	public CodeResponse compileCode(CodeRequest codeRequest)
	{
		codeRequest.setClientId(clientId);
		codeRequest.setClientSecret(clientSecret);


		HttpEntity<CodeRequest> httpEntity = new HttpEntity<CodeRequest>(codeRequest);

		ResponseEntity<CodeResponse> responseEntity = restTemplate.postForEntity(executeCodeAPIURL, codeRequest, CodeResponse.class);
		return responseEntity.getBody();
	}



	public UserCode saveUserCode(CodeRequest codeRequest,CodeResponse codeResponse)
	{
		UserCode userCode  = new UserCode();
		userCode.setScript(codeRequest.getScript());
		userCode.setLanguage(codeRequest.getLanguage());
		userCode.setOutput(codeResponse.getOutput());
		userCode.setTimeOfExecution(codeResponse.getCpuTime());
		userCode.setMemory(codeResponse.getMemory());
		userCode.setDate(LocalDate.now().toString());

		compilerRepo.save(userCode);

		return userCode;

	}

	public String convertFileToCodeRequest(MultipartFile file)
	{
		if(!file.isEmpty())
		{
			try{
				byte[] bytesArray = file.getBytes();

				String codeScript = new String(bytesArray);
				System.out.println(codeScript);

				return codeScript;


			}catch (Exception e)
			{
				e.printStackTrace();
				return null;

			}
		}
		else {
			return null;
		}
	}

}
