package com.xworkz.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.spring.dto.MessageDTO;
import com.xworkz.spring.service.MessageService;

@Controller
public class MessageController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private MessageService messageService;
	
	@Value("${mymessage}")
	private String message;

	public MessageController() {
		LOGGER.info(this.getClass().getSimpleName() + " Created...");
	}

	@RequestMapping("Landing")
	public String onLanding() {
		LOGGER.info("Welcome to landing page of  " + this.getClass().getSimpleName());
		return "Landing";
	}

	@RequestMapping("clickEvent")
	public ModelAndView addMessage(MessageDTO dto) {
		LOGGER.info("Inside addMessage() of " + this.getClass().getSimpleName());
		ModelAndView view = new ModelAndView();
		try {
			boolean check=this.messageService.validateAndSaveMessage(dto);
			if(check==true) {
				LOGGER.info("Check is " + check);
				LOGGER.info("Data Saved in DB");
				view.addObject("obj", dto);
				view.setViewName("LandingSuccess");
				return view;
			}else {
				LOGGER.info("Data is not Saved in DB");
				view.addObject("errorMsg", message);
				view.setViewName("Landing");
				return view;
			}
		} catch (Exception e) {
			LOGGER.error("Exception occured in Controller " + e.getMessage());
		}
		return view;
	}
}
