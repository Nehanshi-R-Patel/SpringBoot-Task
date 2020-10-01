package com.xworkz.spring.service;

import org.springframework.ui.Model;

import com.xworkz.spring.dto.MessageDTO;

public interface MessageService {
	boolean validateAndSaveMessage(MessageDTO messageDTO, Model model);
}
