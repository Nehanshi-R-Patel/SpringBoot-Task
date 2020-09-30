package com.xworkz.spring.service;

import com.xworkz.spring.dto.MessageDTO;

public interface MessageService {
	public boolean validateAndSaveMessage(MessageDTO messageDTO);
}
