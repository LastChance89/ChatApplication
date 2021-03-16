package main.java.com.models;

import java.util.Date;

public class User {
	
	private String username;
	private String password; 
	private String createdDate; 
	private String hint; 
	private String email;
	private String status;
	
	
	
	public User() {
		
	}
	public User(String username, String password, String createdDate, 
			String hint, String email, String status) {
		this.username = username;
		this.password = password; 
		this.createdDate = createdDate;
		this.hint = hint; 
		this.email = email;
		this.status = status;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getHint() {
		return hint;
	}
	
	public void setHint(String hint) {
		this.hint = hint;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
