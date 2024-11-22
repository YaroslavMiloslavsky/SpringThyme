package com.mygane.yaro.demo.service.api;

import java.util.Collection;

import com.mygane.yaro.demo.dto.hello.SaveHelloDto;

public interface GeneralService<T> {
	T sayHello();
	T sayHelloToMe(String me);
	T saveNewHello(SaveHelloDto saveHello);
	Collection<T> getAll();
}
