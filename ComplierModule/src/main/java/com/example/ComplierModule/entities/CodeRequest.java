package com.example.ComplierModule.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CodeRequest {
	
	 private String clientId;
	    private String clientSecret;
	    private String script;
	    private String stdin;
	    private String language;
	    private String versionIndex;
	    private boolean compileOnly = false;
	    

}
