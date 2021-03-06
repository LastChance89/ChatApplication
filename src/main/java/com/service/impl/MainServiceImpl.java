package main.java.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.dao.UserDao;
import main.java.com.models.User;
import main.java.com.service.MainService;

@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	UserDao userDao;
	
	public String createUser(User user) {
		return userDao.createUser(user);
	}
	
	public User login(List<String> credentials) {
		return userDao.loginUser(credentials);
	}

}
