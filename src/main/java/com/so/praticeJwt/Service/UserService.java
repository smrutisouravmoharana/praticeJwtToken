package com.so.praticeJwt.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.so.praticeJwt.Model.User;
import com.so.praticeJwt.Repository.UserRepository;



@Service
public class UserService {

//private List<User> store=new ArrayList<>();
	
//	public UserService()
//	{
//		store.add(new User(UUID.randomUUID().toString(), "Durgesh Tiwari", "durgesh@123"));
//		store.add(new User(UUID.randomUUID().toString(), "Harsh Tiwari", "harsh@123"));
//		store.add(new User(UUID.randomUUID().toString(), "Ankit Tiwari", "ankit@123"));
//	}
      @Autowired
      private UserRepository userRepository;
	
      @Autowired
      private PasswordEncoder passwordEncoder;

	public List<User> getUser()
	{
		//return this.store;
		
		return userRepository.findAll();
	}
	
	public User createUser(User user)
	{
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
