package com.joseway.ngspringsec.controllerApi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.joseway.ngspringsec.model.Projet;
import com.joseway.ngspringsec.services.ProjetService;

@SpringBootTest
class ProjetControllerApiTest {

	@org.junit.jupiter.api.Test
	public void contextLoads() {
	}
	
	@InjectMocks
	private ProjetControllerApi controller;
	@Mock
	private ProjetService service;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@org.junit.jupiter.api.Test
	void testFindById() {
		Projet projetTest= new Projet(1l,"projet","projettest", 45l, 0l, "ujebf");
		when(service.findById(projetTest.getId())).thenReturn(projetTest);
		
		Projet expected = controller.findById(projetTest.getId());
		
		assertThat(expected).isNotNull();
		assertThat(projetTest).isEqualTo(expected);
		assertThat(projetTest.getId()).isEqualTo(expected.getId());
	}
	
	@org.junit.jupiter.api.Test
	void testFindAll() {
		List<Projet> projets = new ArrayList<Projet>();
			Projet p1 = new Projet (1l,"projet","projettest", 45l, 0l, "ujebf");
			Projet p2 = new Projet (2l,"projet","projettest", 568l, 0l, "ujefebf");
			projets.add(p1);
			projets.add(p2);
			when(service.findAll()).thenReturn(projets);
			List<Projet> expected= controller.findAll();
			
			assertThat(expected).isNotNull();
			assertThat(expected.size()).isEqualTo(2);
			assertThat(expected).contains(p2);
	}
	
	@org.junit.jupiter.api.Test
	void testSave() {
		Projet p = new Projet(1l,"projet","projettest", 45l, 0l, "ujebf");
		when(service.save(p)).thenReturn(p);
		
		Projet expected = controller.save(p);
		
		assertThat(expected).isNotNull();
		assertThat(p).isEqualTo(expected);
	}
}
