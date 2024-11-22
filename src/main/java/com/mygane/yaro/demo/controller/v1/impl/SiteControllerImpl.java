package com.mygane.yaro.demo.controller.v1.impl;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mygane.yaro.demo.controller.v1.api.SiteController;
import com.mygane.yaro.demo.dto.response.GeneralResponse;
import com.mygane.yaro.demo.service.api.GeneralService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/home-site")
public class SiteControllerImpl implements SiteController {
	
	@NonNull private final GeneralService<GeneralResponse> service;

	@Override
	@GetMapping
	public String home(Model model) {
		final List<GeneralResponse> repsonses = (List<GeneralResponse>) service.getAll();
		final List<String> textFromResponses = repsonses.stream().map(e -> e.message()).toList();
		textFromResponses.forEach(log::info);
		model.addAttribute("greetings", textFromResponses);
		return "home";
	}

}
