package com.mygane.yaro.demo.model;

import org.springframework.http.HttpStatus;

import com.mygane.yaro.demo.dto.response.GeneralResponse;

public class HelloMapper {
	
	public static GeneralResponse createFromHello(HelloModel hello) {
		return new GeneralResponse(hello.getMessage(), HttpStatus.OK.toString());
	}
}
