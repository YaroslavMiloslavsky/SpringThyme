package com.mygane.yaro.demo.service;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat; 

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mygane.yaro.demo.service.impl.GeneralServiceImpl;

@ExtendWith(MockitoExtension.class)
class GeneralServiceImplTest {
	
	@InjectMocks
	private GeneralServiceImpl generalService;
	
	@Test
	void sayHelloNotNullTest() {
		final String name = "Test";
		final var response = generalService.sayHelloToMe(name);
		
		assertThat(response, notNullValue());
		assertThat(response.message(), containsString(name));
	}
	
	@Test
	void sayHelloNullTest() {
		final var response = generalService.sayHelloToMe(null);
		
		assertThat(response, notNullValue());
		assertThat(response.message(), equalTo("Hello"));
	}

}
