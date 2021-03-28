package main.java.com.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import main.java.com.dao.UserDao;
import main.java.com.extractor.UserLoginExtractor;
import main.java.com.models.User;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate template;

	private static final String CREATE_USER_QUERY = "INSERT INTO USER VALUES (?,?,?,?,?,?)";
	private static final String LOGIN_USER_QUERY = "SELECT USERNAME FROM USER WHERE USER_NAME = ? AND PASSWORD = ?";

	@Override
	public String createUser(User user) {
		try {
			template.update(CREATE_USER_QUERY, new Object[] { user.getUsername(), user.getPassword(),
					user.getCreatedDate(), user.getHint(), user.getEmail(), user.getStatus() });
			return "User " + user.getUsername() + " created!";

		} catch (DataAccessException e) {
			e.printStackTrace();
			return "Failed to create user";
		}
	}

	@Override
	public User loginUser(String[] credentials) {
		return template.query(LOGIN_USER_QUERY , new Object[] {credentials[0], credentials[1]}, new int[] {}, new UserLoginExtractor());
	}
	
	
	

}
