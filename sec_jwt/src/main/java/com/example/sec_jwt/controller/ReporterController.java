package com.example.sec_jwt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sec_jwt.auth.CustomUserDetails;
import com.example.sec_jwt.dto.ArticleDto;
import com.example.sec_jwt.entity.ArticleEntity;
import com.example.sec_jwt.repository.ArticleRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/reporter")
public class ReporterController {

	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping("/article")
	public ArticleDto getArticle(@RequestParam("bno") int bno) {
		Optional<ArticleEntity> result = articleRepository.findById(bno);
		ArticleEntity article = result.get();
		ArticleDto articleDto = article.EntityToDto();
		
		if(articleDto != null) {
			return articleDto;
		}
		return null;
	}
	
	@PostMapping("/article")
	public String postArticle(ArticleDto articleDto) {
		
		System.out.println("post ....." + articleDto);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails user = (CustomUserDetails)authentication.getPrincipal();
		String username = user.getUsername();
		String password = user.getPassword();
		String role = user.getRole();
		
		System.out.println("post...user : " + username + "/" + password + "/" + role);
		
		ArticleEntity articleEntity = articleDto.DtoToEntity(articleDto);
		
		ArticleEntity result = articleRepository.save(articleEntity);
		if(result != null) {
			return "saved!!";
		}
		
		return "woops!!";
	}
	
	@PutMapping("/article")
	public String putArticle(ArticleDto articleDto) {
		
		return "";
	}
	
	@DeleteMapping("/article/{bno}")
	public String deleteArticle(@PathVariable("bno") int bno) {
		
		return "";
	}
}
