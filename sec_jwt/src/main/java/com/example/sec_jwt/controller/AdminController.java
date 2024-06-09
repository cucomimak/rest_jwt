package com.example.sec_jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class AdminController {

    @GetMapping("/main")
    public String adminP() {
    	
        return "Manager Page......";
    }
}
