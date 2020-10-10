package com.xworkz.spring.service;

import org.springframework.ui.Model;

import com.xworkz.spring.dto.AppInfoDTO;

public interface AppInfoService {
	boolean validateAndSave(AppInfoDTO appInfoDTO, Model model);
}
