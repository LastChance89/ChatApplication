package main.java.com.dao;

import java.util.List;

import main.java.com.models.User;


public interface UserDao {

	public String createUser(User user);
	public User loginUser(List<String> credentials);
}
