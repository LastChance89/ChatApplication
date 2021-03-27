package main.java.com.dao;

import org.springframework.stereotype.Component;

import main.java.com.models.User;


public interface UserDao {

	public String createUser(User user);
}
