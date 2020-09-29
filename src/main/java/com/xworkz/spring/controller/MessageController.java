package com.xworkz.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.spring.entity.MessageEntity;
import com.xworkz.spring.service.MessageService;

@Controller
public class MessageController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private MessageService messageService;

	public MessageController() {
		LOGGER.info(this.getClass().getSimpleName() + " Created...");
	}

	@RequestMapping("Landing")
	public String onLanding() {
		LOGGER.info("Hello welcome to Home Page... ");
		return "Landing";
	}

	@RequestMapping("clickEvent")
	public ModelAndView addMessage(MessageEntity entity) {
		LOGGER.info("Inside addMessage() of controller... ");
	
		try {
			entity.setName(entity.getName());
			entity.setMessage(entity.getMessage());
			messageService.saveMessage(entity);
			ModelAndView view = new ModelAndView();
			view.addObject("obj", entity);
			view.setViewName("LandingSuccess");
			return view;
		} catch (Exception e) {
			LOGGER.error("Exception occured in Controller " + e.getMessage());
		}
		return null;
	}
}
