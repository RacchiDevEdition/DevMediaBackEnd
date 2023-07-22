package com.training.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.api.dto.CategoryDto;
import com.training.api.models.Category;
import com.training.api.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<CategoryDto> findAll() {
		List<Category> cat = repository.findAll();
		List<CategoryDto> findAll = cat.stream().map(x -> new CategoryDto(x)).toList();
		return findAll;
	}

	public List<CategoryDto> findById(Long id) {
		Optional<Category> cat = repository.findById(id);
		List<CategoryDto> findById = cat.stream().map(x -> new CategoryDto(x)).toList();
		return findById;

	}

	public CategoryDto findByCategory(Long id) {

		List<Category> cat = repository.searchTitleByCategory(id);
		List<CategoryDto> n1 = cat.stream().map(x -> new CategoryDto(x)).toList();
		
		for (CategoryDto dto : n1) {
			if (dto.getId().equals(id)) {

				return dto;

			}

		}
		return null;

	}

	/*
	 * public CategoryDto findByCategory(CategoryDto category) {
	 * 
	 * = repository.findByCategory(category); CategoryDto byCategory = new
	 * CategoryDto(); return byCategory; }
	 */
}
