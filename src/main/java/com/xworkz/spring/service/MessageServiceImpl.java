package com.xworkz.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.spring.dto.MessageDTO;
import com.xworkz.spring.entity.MessageEntity;
import com.xworkz.spring.repository.MessageRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	public MessageServiceImpl() {
		log.info(this.getClass().getSimpleName() + "Created...");
	}

	@Override
	public boolean validateAndSaveMessage(MessageDTO messageDTO, Model model) {
		log.info("invoking validateAndSaveMessage() of " + this.getClass().getSimpleName());
		boolean flag = false;
		try {
			String name = messageDTO.getName();

			if (name != null && !name.isEmpty() && name.length() <= 15 && name.charAt(0) != ' ') {
				log.info("Name is valid");
				flag = true;
			} else {
				log.error("Name is Not valid");
				model.addAttribute("name", "Invalid name");
				flag = false;
				return flag;
			}

			String message = messageDTO.getMessage();
			if (message != null && !message.isEmpty() && message.length() <= 30) {
				log.info("Message is valid");
				flag = true;
			} else {
				log.error("Message is Not valid");
				model.addAttribute("message", "Invalid Message");
				flag = false;
				return flag;
			}

			if (flag == true) {
				MessageEntity entity = new MessageEntity();
				entity.setName(messageDTO.getName());
				entity.setMessage(messageDTO.getMessage());
				entity = messageRepository.save(entity);
				log.info("All fields are good");
				if (entity.getId() != null) {
					messageDTO.setId(entity.getId());
				}
			}
		} catch (Exception e) {
			log.error("Exception occured in Controller " + e.getMessage());
		}
		return flag;
	}
}
