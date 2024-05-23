package com.stackroute.authentication.service;

import com.stackroute.authentication.model.UserInfo;

public interface UserService {

			UserInfo registerUser(UserInfo user);
			
			boolean login(String email,String password);
}
