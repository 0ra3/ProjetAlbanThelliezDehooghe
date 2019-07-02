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

import com.joseway.ngspringsec.model.Category;
import com.joseway.ngspringsec.services.CategoryService;


@RestController
@RequestMapping(value="/api/category")
@PreAuthorize("hasRole('PM') or hasRole('ADMIN') or hasRole('USER')")
public class CategoryControllerApi {
		
	@Autowired 
	private CategoryService categoryService;
		
		@PostMapping(value="")
		public Category save(@RequestBody Category category) {
			return categoryService.save(category);
		}
		
		@GetMapping(value="/{id}")
		public Category findById(@PathVariable("id") Long id) {
			return categoryService.findById(id);
		}
		
		@RequestMapping(value="/{id}/delete")
		public Category delete(@PathVariable("id")Long id) {
			return categoryService.delete(id);
		}
		
		@GetMapping(value="")
		public List<Category> findAll(){
			System.out.println("eclipse ok");
			return categoryService.findAll();
		}
}
