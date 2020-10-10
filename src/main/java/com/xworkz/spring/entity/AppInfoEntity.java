package com.xworkz.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@ToString
@Slf4j
@Entity
@Table(name = "app_info_details")
public class AppInfoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "APP_ID")
	public Integer appId;

	@Column(name = "PROJECT_NAME")
	private String projectName;

	@Column(name = "TEAM_MANAGER")
	private String teamManager;

	@Column(name = "TEAM_EMAIL")
	private String teamEmail;

	@Column(name = "IS_DECOMISSINED")
	private Boolean isDeComissined;

	@Column(name = "DEVELOPED_DATE")
	private Date developedDate;

	@Column(name = "APP_VERSION")
	private String appVersion;

	@Column(name = "LAST_RELEASE")
	private Date lastRelease;

	@Column(name = "NEXT_RELEASE")
	private Date nextRelease;

	@OneToMany(mappedBy = "appInfo", cascade = CascadeType.ALL)
	private List<EnvironmentEntity> environmentList;

	@Column(name = "CREATED_TIMESTAMP")
	private Date createdTimestamp;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_TIMESTAMP")
	private Date updatedTimestamp;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	public AppInfoEntity() {
		log.info(this.getClass().getSimpleName() + " Created");
	}
}
