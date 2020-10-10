package com.xworkz.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xworkz.spring.entity.AppInfoEntity;

public interface AppInfoRepository extends JpaRepository<AppInfoEntity, Integer> {

}
