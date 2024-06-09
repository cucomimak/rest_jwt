package com.example.sec_jwt_client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/login")
	public String root() {
		return "loginForm";
	}
	
	@RequestMapping("/regArticle")
	public String regArticle() {
		return "regArticle";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	@RequestMapping("/manager/main")
	public String managerMain() {
		System.out.println("manager-main...............");
		return "manager/main";
	}
}
