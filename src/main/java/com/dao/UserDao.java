package main.java.com.dao;

import main.java.com.models.User;


public interface UserDao {

	public String createUser(User user);
	public User loginUser(String[] credentials);
}
