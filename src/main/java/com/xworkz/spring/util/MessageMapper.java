package com.xworkz.spring.util;

import org.mapstruct.Mapper;

import com.xworkz.spring.dto.MessageDTO;
import com.xworkz.spring.entity.MessageEntity;

@Mapper(componentModel = "spring")
public interface MessageMapper {

	MessageEntity msgDTOToMsgEntity(MessageDTO messageDTO);

}
