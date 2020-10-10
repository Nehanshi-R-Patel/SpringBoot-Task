package com.xworkz.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.spring.dto.AppInfoDTO;
import com.xworkz.spring.service.AppInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AppInfoController {

	@Autowired
	private AppInfoService appInfoService;

	public AppInfoController() {
		log.info(this.getClass().getSimpleName() + " Created...");
	}

	@RequestMapping("/getAppInfoDetails")
	public String appInfoDetails() {
		log.info("Welcome to appInfo page of " + this.getClass().getSimpleName());
		return "appinfo";
	}

	@InitBinder
	public void initBinding(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@PostMapping("/saveAppInfoDetails")
	public ModelAndView addAppInfoDetails(AppInfoDTO appInfoDTO, Model model) {
		log.info("invoking addAppInfoDetails() of " + this.getClass().getSimpleName());
		ModelAndView view = new ModelAndView();
		view.setViewName("appinfo");
		
		try {
			boolean check = this.appInfoService.validateAndSave(appInfoDTO, model);
			if (check == true) {
				log.info("Check is " + check);
				log.info("Data Saved in DB" + appInfoDTO.toString());
				model.addAttribute("dbDetails", "Data Stored in database");
				return view;
			} else {
				log.error("Data is not Saved in DB");
				model.addAttribute("dbErrorMsg", "Data is not stored in database");
				return view;
			}
		} catch (Exception e) {
			log.error("Exception occured in Controller " + e.getMessage());
		}
		return view;
	}
}
