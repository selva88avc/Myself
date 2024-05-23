package com.stackroute.authentication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserInfo {

	
	@Id
	String useremail;
	
	String password;
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
