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

import com.joseway.ngspringsec.model.Projet;
import com.joseway.ngspringsec.services.ProjetService;



@RestController
@RequestMapping(value="/api/projets")
@PreAuthorize("hasRole('PM') or hasRole('ADMIN') or hasRole('USER')")
public class ProjetControllerApi {

	@Autowired 
	private ProjetService projetService;
	

	@GetMapping(value="")
	public List<Projet> findAll(){
		return projetService.findAll();
	}
	
	@GetMapping (value="/{id}")
	public Projet findById(@PathVariable("id") Long id) {
		return projetService.findById(id);
	}
	
	@PostMapping (value="")
	public Projet save(@RequestBody Projet projet) {
		System.out.println("projet" + projet);
		return projetService.save(projet);
	}
	
	@RequestMapping (value="/{id}/delete")
	public Projet deleteById (@PathVariable("id") Long id) {
		return projetService.deleteById(id);
	}
}
