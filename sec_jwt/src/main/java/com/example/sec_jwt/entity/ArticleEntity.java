package com.example.sec_jwt.entity;

import com.example.sec_jwt.dto.ArticleDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "articles")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleEntity extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ano;
	private String title;
	private String content;
	@ManyToOne
	@JoinColumn(name = "username")
	private ReporterEntity reporter;
	//private MultipartFile file;
	
	public ArticleDto EntityToDto() {
		
		ArticleDto dto = ArticleDto.builder()
							.ano(this.ano)
							.title(this.title)
							.content(this.content)
							.writer(this.reporter.getUsername())
							.regDate(this.getRegDate().toString())
							.modDate(this.getModDate().toString())
							.build();
		
		return dto;
	}
}
