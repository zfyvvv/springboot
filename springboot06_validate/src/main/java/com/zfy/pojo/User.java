package com.zfy.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	@NotBlank(message="用户名不能为空！")  //用户名非空校验
	private String name;
	@NotBlank(message="密码不能为空！")  //密码非空校验
	private String password;
	
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", age=" + age + "]";
	}
	public User(String name, String password, Integer age) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
}
