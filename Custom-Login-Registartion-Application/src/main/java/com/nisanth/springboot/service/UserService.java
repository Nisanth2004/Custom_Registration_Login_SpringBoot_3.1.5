package com.nisanth.springboot.service;

import com.nisanth.springboot.dto.UserDto;
import com.nisanth.springboot.model.User;

public interface UserService
{
  User findByUsername(String username);
  User save(UserDto userDto);
  
}
