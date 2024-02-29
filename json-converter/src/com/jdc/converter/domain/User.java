package com.jdc.converter.domain;

@Json
public class User {

	// convert
	@JsonField
	private String username;

	// convert
	@JsonField(name = "userEmail")
	private String email;

	// convert
	@JsonField
	private String password;

	private String phone;

	// convert
	@JsonField
	private int age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
