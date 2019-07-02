package com.joseway.ngspringsec.services;

import java.util.List;

import com.joseway.ngspringsec.model.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User findById(Long id);
	
	public User save(User user);
		
	public User deleteById(Long id);
	
	public User findByUsername(String username);
}
