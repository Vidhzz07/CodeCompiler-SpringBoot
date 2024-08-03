package com.example.ComplierModule.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CodeResponse {
	
	 private String output;
	 private  int statusCode;
	 private  String memory;
	 private  String cpuTime;
	 private  int compilationStatus;

}
