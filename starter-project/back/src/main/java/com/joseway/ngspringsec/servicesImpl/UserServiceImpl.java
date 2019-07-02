package com.joseway.ngspringsec.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseway.ngspringsec.model.User;
import com.joseway.ngspringsec.repository.UserRepository;
import com.joseway.ngspringsec.services.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User deleteById(Long id) {
		User temp = findById(id);
		userRepository.deleteById(id);
		return temp;
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).get();
	}

}
