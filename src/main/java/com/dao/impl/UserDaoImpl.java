package main.java.com.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import main.java.com.dao.UserDao;
import main.java.com.models.User;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate template;

	private final String createUserQuery = "INSERT INTO USER VALUES (?,?,?,?,?,?)";

	@Override
	public String createUser(User user) {
		try {
			template.update(createUserQuery, new Object[] { user.getUsername(), user.getPassword(),
					user.getCreatedDate(), user.getHint(), user.getEmail(), user.getStatus() });
			return "User " + user.getUsername() + " created!";

		} catch (DataAccessException e) {
			e.printStackTrace();
			return "Failed to create user";
		}
	}

}
