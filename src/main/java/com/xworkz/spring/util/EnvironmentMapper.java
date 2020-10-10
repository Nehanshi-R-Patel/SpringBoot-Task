package com.xworkz.spring.util;

import java.util.List;

import org.mapstruct.Mapper;

import com.xworkz.spring.dto.EnvironmentDTO;
import com.xworkz.spring.entity.EnvironmentEntity;

@Mapper(componentModel = "spring")
public interface EnvironmentMapper {

	List<EnvironmentEntity> dtoToEntity(List<EnvironmentDTO> list);

}
