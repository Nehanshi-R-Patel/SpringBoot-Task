package com.xworkz.spring.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MessageDTO implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageDTO.class);

	private int id;
	private String name;
	private String message;

	public MessageDTO() {
		LOGGER.info(this.getClass().getSimpleName() + " Created...");
	}
}
