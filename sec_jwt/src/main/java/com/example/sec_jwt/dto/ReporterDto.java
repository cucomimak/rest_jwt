package com.example.sec_jwt.dto;

import com.example.sec_jwt.entity.ReporterEntity;

import lombok.Data;

@Data
public class ReporterDto {
	private String username;
	private String password;
	private String name;
	private String email;
	private String role;
	
	public ReporterEntity dtoToEntity() {
		
		ReporterEntity entity = ReporterEntity.builder()
									.username(this.username)
									.password(this.password)
									.name(this.name)
									.email(this.email)
									.role("ROLE_REPORTER")
									.build();
		return entity;
	}
}
