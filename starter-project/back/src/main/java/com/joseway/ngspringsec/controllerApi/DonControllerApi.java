package com.joseway.ngspringsec.controllerApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseway.ngspringsec.model.Don;
import com.joseway.ngspringsec.services.DonService;


@RestController
@RequestMapping(value="/api/dons")
@PreAuthorize("hasRole('PM') or hasRole('ADMIN') or hasRole('USER')")
public class DonControllerApi{

	@Autowired
	private DonService donService;
	
	@GetMapping(value="/{id}")
	public Don findById(@PathVariable("id") Long id) {
	return donService.findById(id);
	}
	
	@PostMapping(value="")
	public Don save(@RequestBody Don don) {
	return donService.save(don);
	}
	
	@GetMapping(value="")
	public List<Don> findAll() {
	return donService.findAll(); 
	}
	
}
