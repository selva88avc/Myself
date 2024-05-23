package com.stackroute.authentication.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.authentication.model.UserInfo;

@Repository
public interface UserRepo extends JpaRepository<UserInfo,String> {
	
	Optional<UserInfo> findByUseremailAndPassword(String email,String pass);

}
