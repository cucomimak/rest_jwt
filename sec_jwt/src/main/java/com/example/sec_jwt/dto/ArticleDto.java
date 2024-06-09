package com.example.sec_jwt.dto;

import com.example.sec_jwt.entity.ArticleEntity;
import com.example.sec_jwt.entity.ReporterEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
	private int ano;
	private String title;
	private String content;
	private String writer;
	private String regDate;
	private String modDate;
	
	
	
	public ArticleEntity DtoToEntity(ArticleDto dto) {
		ReporterEntity reporter = new ReporterEntity();
		reporter.setUsername(dto.getWriter());
		
		ArticleEntity entity = ArticleEntity.builder()
							.ano(null)
							.title(dto.getTitle())
							.content(dto.getContent())
							.reporter(reporter)
							.build();
		
		return entity;
	}
}