package com.zfy.pojo;


public class User {
	private Integer userId;
	private String userName;
	private Integer userAge;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public User(Integer userId, String userName, Integer userAge) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
}
