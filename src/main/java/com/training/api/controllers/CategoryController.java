package com.training.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.api.dto.CategoryDto;
import com.training.api.dto.NewsDto;
import com.training.api.services.CategoryService;
import com.training.api.services.NewsService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@Autowired
	private NewsService nservice;

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
	public List<NewsDto> findByCategory(@ModelAttribute("title") @RequestParam(value = "title") Long id) {

		CategoryDto byCategory = service.findByCategory(id);

		List<NewsDto> dto = nservice.findAll();

		if (dto.get(0).getCategory().contains(byCategory.getId())) {
			return dto;
		}
		return dto;

	}

	/*
	 * @GetMapping(value = "/{id}/{category}") public CategoryDto
	 * findByCategory(@RequestParam("category") CategoryDto category) { CategoryDto
	 * news = service.findByCategory(category); List<CategoryDto> byCategory =
	 * news.getCategory(); return byCategory.get(0); }
	 */
}
