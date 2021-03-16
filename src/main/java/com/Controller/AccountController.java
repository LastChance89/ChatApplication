package main.java.com.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.models.User;

@RestController
public class AccountController {

	
	@PostMapping("/createAccount")
	//@RequestBody User user
	public String createAccount(@RequestBody User user ) {
		System.out.println("meow");
		return "Generic Response";
	}
	
}
