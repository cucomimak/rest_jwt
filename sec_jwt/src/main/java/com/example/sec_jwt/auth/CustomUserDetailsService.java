package com.example.sec_jwt.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.sec_jwt.entity.ReporterEntity;
import com.example.sec_jwt.repository.ReporterRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private ReporterRepository reporterRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username : " + username);
		
		ReporterEntity reporter = reporterRepository.findByUsername(username);
		
		System.out.println("userEntity : " + reporter);
		
		if(reporter != null) {
			CustomUserDetails userData = new CustomUserDetails(reporter);
			return userData;
		}
		
		return null;
	}

}
