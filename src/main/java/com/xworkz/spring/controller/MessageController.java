package com.xworkz.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.spring.dto.MessageDTO;
import com.xworkz.spring.service.MessageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MessageController {

	
	@Autowired
	private MessageService messageService;

	public MessageController() {
		log.info(this.getClass().getSimpleName() + " Created...");
	}

	@RequestMapping("home")
	public String onLanding() {
		log.info("Welcome to home page of " + this.getClass().getSimpleName());
		return "home";
	}

	@RequestMapping("clickevent")
	public ModelAndView addMessage(MessageDTO dto, Model model) {
		log.info("invoking addMessage() of " + this.getClass().getSimpleName());
		ModelAndView view = new ModelAndView();
		try {
			boolean check = this.messageService.validateAndSaveMessage(dto, model);
			if (check == true) {
				log.info("Check is " + check);
				log.info("Data Saved in DB");
				view.addObject("obj", dto);
				view.setViewName("success");
				return view;
			} else {
				log.error("Data is not Saved in DB");
				view.setViewName("home");
				return view;
			}
		} catch (Exception e) {
			log.error("Exception occured in Controller " + e.getMessage());
		}
		return view;
	}
}
