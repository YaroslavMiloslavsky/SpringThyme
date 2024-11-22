package com.mygane.yaro.demo.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mygane.yaro.demo.dto.hello.SaveHelloDto;
import com.mygane.yaro.demo.dto.response.GeneralResponse;
import com.mygane.yaro.demo.model.HelloMapper;
import com.mygane.yaro.demo.model.HelloModel;
import com.mygane.yaro.demo.repository.HelloRepository;
import com.mygane.yaro.demo.service.api.GeneralService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class GeneralServiceImpl implements GeneralService<GeneralResponse> {
	
	@NonNull private final HelloRepository repository;
	
	@Override
	public GeneralResponse sayHello() {
		return getResponse(null);
	}

	@Override
	public GeneralResponse sayHelloToMe(String me) {
		return getResponse(me);
	}

	private GeneralResponse getResponse(String me) {
		final var responseStatus = HttpStatus.OK.toString();
		final var isText = (StringUtils.hasText(me));
		log.info("Has text: {}", isText);
		final var responseMsg = "Hello" + (isText? " " + me : "");
		return new GeneralResponse(
				responseMsg,
				responseStatus);
	}

	@Override
	public GeneralResponse saveNewHello(SaveHelloDto saveHello) {
		var toSave = new HelloModel();
		toSave.setMessage(saveHello.msg());
		var response = repository.save(toSave);
		return new GeneralResponse("Saved " + response.getMessage(), HttpStatus.ACCEPTED.toString());
	}

	@Override
	public Collection<GeneralResponse> getAll() {
		final List<HelloModel> allHellos = repository.findAll();
		final List<GeneralResponse> response = allHellos
				.stream()
				.map(HelloMapper::createFromHello)
				.toList();
		
		return response;
	}

}
