package com.xdclass.domain;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;
import com.xdclass.validator.MyConstraint;

public class User {
	
	public interface UserSimpleView{}

	public interface UserDatailView extends UserSimpleView{}; 
	
	private String  id;
	
	@JsonView(UserSimpleView.class)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@MyConstraint(message = "my constraint")
	private String username;
	
	@NotBlank(message="密码不能为空")
	private String password;
	
	@Past(message="生日必须为过去的时间")
	private Date birthday;

	@JsonView(UserSimpleView.class)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@JsonView(UserSimpleView.class)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@JsonView(UserDatailView.class)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
