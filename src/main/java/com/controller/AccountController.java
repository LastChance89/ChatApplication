package main.java.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.models.User;
import main.java.com.service.MainService;

@RestController
@CrossOrigin
public class AccountController {

	@Autowired 
	MainService mainService;
	
	@PostMapping("/createAccount")
	public String createAccount(@RequestBody User user ) {
		return mainService.createUser(user);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody String[] credentials) {
		return mainService.login(credentials);
	}
	
}
