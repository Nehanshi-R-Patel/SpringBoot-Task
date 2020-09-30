package com.xworkz.spring.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.spring.dto.MessageDTO;
import com.xworkz.spring.entity.MessageEntity;
import com.xworkz.spring.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

	@Autowired
	private MessageRepository messageRepository;

	public MessageServiceImpl() {
		LOGGER.info(this.getClass().getSimpleName() + "Created...");
	}

	@Override
	public boolean validateAndSaveMessage(MessageDTO messageDTO) {
		LOGGER.info("invoking saveMessage() of " + this.getClass().getSimpleName());
		boolean flag = false;

		String name = messageDTO.getName();

		if (name != null && !name.isEmpty() && name.length() <= 15 && name.charAt(0) != ' ') {
			LOGGER.info("Name is valid");
			flag = true;
		} else {
			LOGGER.error("Name is Not valid");
			flag = false;
			return flag;
		}

		String message = messageDTO.getMessage();
		if (message != null && !message.isEmpty() && message.length() <= 30) {
			LOGGER.info("Message is valid");
			flag = true;
		} else {
			LOGGER.error("Message is Not valid");
			flag = false;
			return flag;
		}

		try {
			MessageEntity entity = new MessageEntity();
			entity.setName(messageDTO.getName());
			entity.setMessage(messageDTO.getMessage());
			if (flag == true) {
				entity = messageRepository.save(entity);
				LOGGER.info("All fields are good");
				if (Objects.nonNull(entity)) {
					messageDTO.setId(entity.getId());
				}
			}
		} catch (Exception e) {
			LOGGER.error("Exception occured in Controller " + e.getMessage());
		}
		return flag;
	}
}
