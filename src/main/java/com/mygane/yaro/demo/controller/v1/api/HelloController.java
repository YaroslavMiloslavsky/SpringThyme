package com.mygane.yaro.demo.controller.v1.api;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import com.mygane.yaro.demo.dto.hello.SaveHelloDto;

public interface HelloController<T> {
	ResponseEntity<T> sayGeneralHello(final String name);
	ResponseEntity<T> save(final SaveHelloDto saveHello);
	ResponseEntity<Collection<T>> getAll();
}
