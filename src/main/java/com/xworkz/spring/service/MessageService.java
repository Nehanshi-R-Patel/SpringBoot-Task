package com.xworkz.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.spring.entity.MessageEntity;
import com.xworkz.spring.repository.MessageRepository;

@Service
public class MessageService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);

	@Autowired
	private MessageRepository messageRepository;

	public MessageService() {
		LOGGER.info(this.getClass().getSimpleName() + "Created...");
	}

	public void saveMessage(MessageEntity entity) {
		LOGGER.info("Inside ValidateAndSave of MessageService...");

		try {
			messageRepository.save(entity);
			LOGGER.info("Data Saved in DB");
		} catch (Exception e) {
			LOGGER.error("Exception occured in Controller " + e.getMessage());
		}
	}
}
