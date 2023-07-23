package com.training.api.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.api.dto.CategoryDto;
import com.training.api.models.Category;
import com.training.api.models.News;
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

	public Set<News> findByCategory(Long id) {

		List<Category> cat = repository.searchTitleByCategory(id);
		for (Category c : cat) {
			if(c.getId() == id)
			return c.getNews();

		}

		return null;

	}
}
