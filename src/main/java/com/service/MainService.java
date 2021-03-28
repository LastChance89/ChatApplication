package main.java.com.service;

import main.java.com.models.User;

public interface MainService {
	public String createUser(User user);
	public User login(String[] credentials);
}
