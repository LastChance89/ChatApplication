package main.java.com.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import main.java.com.models.User;

public class UserLoginExtractor implements ResultSetExtractor<User> {

	@Override
	public User extractData(ResultSet rs) throws SQLException, DataAccessException {
		if(rs.next()) {
			User user = new User(); 
			user.setUsername(rs.getString("USER_NAME"));
			return user;
		}
		return null;
	}
}
