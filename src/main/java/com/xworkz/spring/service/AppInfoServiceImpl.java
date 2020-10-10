package com.xworkz.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.spring.dto.AppInfoDTO;
import com.xworkz.spring.entity.AppInfoEntity;
import com.xworkz.spring.entity.EnvironmentEntity;
import com.xworkz.spring.repository.AppInfoRepository;
import com.xworkz.spring.util.AppInfoMapper;
import com.xworkz.spring.util.EnvironmentMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AppInfoServiceImpl implements AppInfoService {

	@Autowired
	private AppInfoRepository appInfoRepository;

	@Autowired
	private AppInfoMapper appInfoMapper;

	@Autowired
	private EnvironmentMapper environmentMapper;

	public AppInfoServiceImpl() {
		log.info(this.getClass().getSimpleName() + " Created");
	}

	@Override
	public boolean validateAndSave(AppInfoDTO appInfoDTO, Model model) {
		log.info("invoking validateAndSave() of " + this.getClass().getSimpleName());
		boolean flag = false;
		try {
			String name = appInfoDTO.getProjectName();
			if (name != null && !name.isEmpty() && name.length() <= 30 && name.charAt(0) != ' ') {
				log.info("Project Name is valid");
				flag = true;
			} else {
				log.error("Project Name is not valid");
				model.addAttribute("projectName", "Invalid ProjectName");
				flag = false;
				return flag;
			}

			String email = appInfoDTO.getTeamEmail();
			if (email != null && !email.isEmpty() && email.length() <= 50 && email.charAt(0) != ' ') {
				log.info("Team Contact email is valid");
				flag = true;
			} else {
				log.error("Team Contact email is not valid");
				model.addAttribute("teamContactEmail", "Invalid TeamContact Email");
				flag = false;
				return flag;
			}

			if (flag == true) {
				AppInfoEntity appInfoEntity = this.appInfoMapper.dtoTOEntity(appInfoDTO);

				List<EnvironmentEntity> environmentList = this.environmentMapper
						.dtoToEntity(appInfoDTO.getEnvironmentList());

				for (int i = 0; i < environmentList.size(); i++) {
					environmentList.get(i).setAppInfo(appInfoEntity);
				}

				appInfoEntity.setEnvironmentList(environmentList);

				Date currentDateAndTime = new Date();

				appInfoEntity.setCreatedTimestamp(currentDateAndTime);
				appInfoEntity.setCreatedBy("Nehanshi");
				appInfoEntity.setUpdatedTimestamp(currentDateAndTime);
				appInfoEntity.setUpdatedBy("Neha");

				appInfoEntity = this.appInfoRepository.save(appInfoEntity);

				log.info("All fields are good");

				if (appInfoEntity.getAppId() != null) {
					appInfoDTO.setAppId(appInfoEntity.getAppId());
				}
			}
		} catch (Exception e) {
			log.error(" Exception occurred in validateAndSave() of " + e.getMessage());
		}
		return flag;
	}
}
