package com.exam.service;
import com.exam.model.UserRole;
import java.util.*;
import com.exam.model.User;


public interface UserService {

	//Creating User 
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	//get user by userName
	public User getUser(String username);
	
	//delete user by id
	public void deleteUser(Long userId);
	
	//update user by id
//	public User updateUser(Long userId);
	
	
}
