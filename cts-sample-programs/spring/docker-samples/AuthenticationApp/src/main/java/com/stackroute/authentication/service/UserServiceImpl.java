package com.stackroute.authentication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.authentication.model.UserInfo;
import com.stackroute.authentication.repo.UserRepo;

 


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo repo;
	
	@Override
	public UserInfo registerUser(UserInfo user) {
		Optional<UserInfo> userinfo=repo.findById(user.getUseremail());
		if(userinfo.isEmpty())
		{
		return	repo.save(user);
	 
		}
		else
			return null;
	}

	@Override
	public boolean login(String email, String password) {
		
	Optional<UserInfo> optuserinfo=	repo.findByUseremailAndPassword(email, password);
	
	if(optuserinfo.isPresent())
		return true;
	else
		return false;
	}

}
