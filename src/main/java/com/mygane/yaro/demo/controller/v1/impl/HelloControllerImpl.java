package com.mygane.yaro.demo.controller.v1.impl;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mygane.yaro.demo.controller.v1.api.HelloController;
import com.mygane.yaro.demo.dto.hello.SaveHelloDto;
import com.mygane.yaro.demo.dto.response.GeneralResponse;
import com.mygane.yaro.demo.service.api.GeneralService;

import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/hello")
@RequiredArgsConstructor
public class HelloControllerImpl implements HelloController<GeneralResponse> {

	@NonNull private final GeneralService<GeneralResponse> generalService;
	
	@Override
	@GetMapping
	public ResponseEntity<GeneralResponse> sayGeneralHello(@Nullable @RequestParam final String name) {
		log.info("Calling sayGeneralHello with name: {}", name);
		final var serviceResponse = generalService.sayHelloToMe(name);
		if (serviceResponse == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralResponse("Error", HttpStatus.BAD_REQUEST.toString()));
		}
		
		return ResponseEntity.ok(serviceResponse);
	}

	@Override
	@PostMapping("/save")
	public ResponseEntity<GeneralResponse> save(@Valid @RequestBody SaveHelloDto saveHello) {
		log.info("Save new hello DTO");
		return ResponseEntity.accepted().body(generalService.saveNewHello(saveHello));
	}

	@Override
	@GetMapping("/all")
	public ResponseEntity<Collection<GeneralResponse>> getAll() {
		return ResponseEntity.ok(generalService.getAll());
	}



}
