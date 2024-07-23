package com.jdc.converter.domain;

@Json
public class User {

	@JsonField
	private String username;

	@JsonField
	private String email;

	private String password;

	@JsonField(name = "phone_no")
	private String phone;
	
	@JsonField
	private Character grade;

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
	
	public char getGrade() {
		return grade;
	}
	
	public void setGrade(char grade) {
		this.grade = grade;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
