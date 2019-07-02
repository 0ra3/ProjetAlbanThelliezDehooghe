package com.joseway.ngspringsec.controllerApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseway.ngspringsec.model.User;
import com.joseway.ngspringsec.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/user")
@PreAuthorize("hasRole('PM') or hasRole('ADMIN') or hasRole('USER')")
public class UserControllerApi {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="")
	public List<User> findAll(){
		return userService.findAll();
	}
	@GetMapping(value="/{id}")
	public User findById(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	@GetMapping(value="/current/{username}")
	public User findByUsername(@PathVariable("username") String username) {
		return userService.findByUsername(username);
	}
	@PostMapping(value="")
	public User save(@RequestBody User user) {
		return userService.save(user);
	}
	@RequestMapping (value="/{id}/deleteUser")
	public User deleteById(@PathVariable("id")Long id) {
		return userService.deleteById(id);
	}
}
