package com.xworkz.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xworkz.spring.entity.MessageEntity;

public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {

}
