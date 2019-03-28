package com.springboot.jpa.basics.springbootjpabasics;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.jpa.basics.springbootjpabasics.entity.User;
import com.springboot.jpa.basics.springbootjpabasics.service.UserRepository;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {

	private static Logger logger=LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user=new User("Jack","Admin");
		userRepository.save(user);
		logger.info("User "+user+" has been inserted");
		
		User user2=new User("Mack","User");
		userRepository.save(user2);
		logger.info("User "+user2+" has been inserted");
		
		User user3=new User("Snack","Admin");
		userRepository.save(user3);
		logger.info("User "+user3+" has been inserted");
		
		
		logger.info("-----------------------------------------");
		
		for(User us:userRepository.findAll()) {
			logger.info("User is "+us);
		}
		
		logger.info("-----------------------------------------");
		
		Optional<User> userWithId=userRepository.findById(1L);
		logger.info("User with id 1L is "+userWithId);
		logger.info("-----------------------------------------");
		
		List<User> listUser=userRepository.findByRole("User");
		for (User user4 : listUser) {
			logger.info("User with role 'user' "+user4);
		}
		
		logger.info("-----------------------------------------");
	}

}
