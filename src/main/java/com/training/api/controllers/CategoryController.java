package com.training.api.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.api.dto.CategoryDto;
import com.training.api.models.News;
import com.training.api.services.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseEntity<List<CategoryDto>> findAll() {
		List<CategoryDto> news = service.findAll();
		return ResponseEntity.ok().body(news);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<List<CategoryDto>> findById(@PathVariable Long id) {
		List<CategoryDto> byId = service.findById(id);
		return ResponseEntity.ok().body(byId);
	}

	@GetMapping(value = "/titlesearch")
	public Set<News> findByCategory(@ModelAttribute("id") @RequestParam(value = "id") Long id) {

		Set<News> c1 = service.findByCategory(id);

		return c1;
	}
}
