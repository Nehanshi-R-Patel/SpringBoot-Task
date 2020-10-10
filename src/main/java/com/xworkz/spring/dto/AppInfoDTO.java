package com.xworkz.spring.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@ToString
@Slf4j
public class AppInfoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer appId;

	private String projectName;

	private String teamManager;

	private String teamEmail;

	private Boolean isDeComissined;

	private Date developedDate;

	private String appVersion;

	private Date lastRelease;

	private Date nextRelease;

	ArrayList<EnvironmentDTO> environmentList;

	private Date createdTimestamp;

	private String createdBy;

	private Date updatedTimestamp;

	private String updatedBy;

	public AppInfoDTO() {
		log.info(this.getClass().getSimpleName() + " Created");
	}

}
