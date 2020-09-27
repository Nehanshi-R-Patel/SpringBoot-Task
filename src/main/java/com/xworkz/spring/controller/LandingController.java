package com.xworkz.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.spring.dto.LandingDTO;

@Controller
public class LandingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LandingController.class);

	public LandingController() {
		LOGGER.info(this.getClass().getSimpleName() + " Created...");
	}

	@RequestMapping("Landing")
	public String onLanding() {
		LOGGER.info("Hello welcome to Home Page... ");
		return "Landing";
	}

	@RequestMapping("clickEvent")
	public String onLandSuccess(LandingDTO landingDTO, Model model) {
		LOGGER.info("Inside onLandSuccess()... ");
		LOGGER.info("Name is: " + landingDTO.getName() + "\t Message is: " + landingDTO.getMessage());
		model.addAttribute("nameOfSender", landingDTO.getName());
		model.addAttribute("yourMessage", landingDTO.getMessage());
		return "LandingSuccess";
	}
}
