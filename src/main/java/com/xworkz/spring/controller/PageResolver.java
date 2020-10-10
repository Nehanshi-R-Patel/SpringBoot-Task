package com.xworkz.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PageResolver {

	public PageResolver() {
		log.info(this.getClass().getSimpleName() + " Created");
	}

	@RequestMapping("/")
	public static String homePage() {
		log.info(" Welcome to the index page");
		return "index";
	}
}
