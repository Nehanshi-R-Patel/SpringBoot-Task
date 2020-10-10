package com.xworkz.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Entity
@Table(name = "environment_details")
public class EnvironmentEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ENVIRONMENT_ID")
	public Long envId;

	@Column(name = "ENVIRONMENT")
	private String environment;

	@Column(name = "URL")
	private String url;

	@Column(name = "IS_ACCESSIBLE")
	private Boolean isAccessible;

	@ManyToOne
	@JoinColumn(name = "APP_ID", nullable = false)
	private AppInfoEntity appInfo;

	public EnvironmentEntity() {
		log.info(this.getClass().getSimpleName() + " Created");
	}
}
