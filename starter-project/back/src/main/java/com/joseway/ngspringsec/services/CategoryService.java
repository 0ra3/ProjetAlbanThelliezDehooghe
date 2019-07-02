package com.joseway.ngspringsec.services;

import java.util.List;

import com.joseway.ngspringsec.model.Category;

public interface CategoryService {
	
	public Category save(Category category);
	
	public Category findById(Long id);
	
	public Category delete(Long id);
	
	public List<Category> findAll();
}
