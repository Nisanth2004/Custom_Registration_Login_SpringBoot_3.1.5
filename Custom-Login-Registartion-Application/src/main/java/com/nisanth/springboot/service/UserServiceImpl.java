package com.nisanth.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nisanth.springboot.dto.UserDto;
import com.nisanth.springboot.model.User;
import com.nisanth.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	PasswordEncoder  passwordEncoder;
	private UserRepository userRepository;

	@Override
	public User findByUsername(String username) 
	{
		
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(UserDto userDto) {
		User user =new User(userDto.getUsername(),passwordEncoder.encode(userDto.getPassword()),userDto.getFullname());
		return userRepository.save(user);
	}

	public UserServiceImpl(UserRepository userRepository) 
	{
		
		this.userRepository = userRepository;
	}
	

}
