package com.fortech.testApp.services;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.fortech.testApp.models.User;

@Service
public interface IUserService {
	
	String signin(String username, String password);
	String signup(User user);
	void delete(String username);
	User search(String username);
	User whoami(HttpServletRequest req);
	String refresh(String username);
}
