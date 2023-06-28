package com.exam;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.service.UserService;

import java.util.HashSet;
import java.util.Set;
import com.exam.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting code...");
		
		User user =new User();
		
		user.setFirstName("Aditya");
		user.setLastName("Upadhyay");
		user.setUsername("aditya8233");
		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
		user.setEmail("aditya@gmail.com");
		user.setProfile("default.png");
		
		Role role1=new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");
		
		Set<UserRole> userRoleSet=new HashSet<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		User user1=this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());
		
		
	}

}
