package com.xworkz.spring.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@ToString
@Slf4j
public class MessageDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String message;

	public MessageDTO() {
		log.info(this.getClass().getSimpleName() + " Created...");
	}
}
