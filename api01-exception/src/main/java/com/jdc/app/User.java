package com.jdc.app;

public class User extends Account {

	private String username;
	private String password;
	
	@Override
	public GrandChild create() {
		return null;
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
	
	public User copy(String username, String password) throws CloneNotSupportedException {
		setUsername(username);
		setPassword(password);
		return (User)this.clone();
	}

}
