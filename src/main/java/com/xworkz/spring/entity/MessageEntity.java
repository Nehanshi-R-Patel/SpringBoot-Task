package com.xworkz.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class MessageEntity implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageEntity.class);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private String message;

	public MessageEntity() {
		LOGGER.info(this.getClass().getSimpleName() + "Created...");
	}
}
