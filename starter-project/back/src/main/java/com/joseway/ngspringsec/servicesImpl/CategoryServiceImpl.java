package com.joseway.ngspringsec.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseway.ngspringsec.model.Category;
import com.joseway.ngspringsec.repository.CategoryRepository;
import com.joseway.ngspringsec.services.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category findById(Long id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category delete(Long id) {
		Category temp = findById(id);
		categoryRepository.findById(id);
		return temp;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

}
