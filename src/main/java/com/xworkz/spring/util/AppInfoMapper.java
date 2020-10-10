package com.xworkz.spring.util;

import org.mapstruct.Mapper;

import com.xworkz.spring.dto.AppInfoDTO;
import com.xworkz.spring.entity.AppInfoEntity;

@Mapper(componentModel = "spring")
public interface AppInfoMapper {

	AppInfoEntity dtoTOEntity(AppInfoDTO appInfoDTO);
}
