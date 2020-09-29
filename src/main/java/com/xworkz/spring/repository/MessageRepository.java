package com.xworkz.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.xworkz.spring.entity.MessageEntity;

public interface MessageRepository extends CrudRepository<MessageEntity, Integer> {

}
