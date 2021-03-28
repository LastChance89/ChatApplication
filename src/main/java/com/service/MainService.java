package main.java.com.service;

import java.util.List;

import main.java.com.models.User;

public interface MainService {
	public String createUser(User user);
	public User login(List<String> credentials);
}
