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

import com.training.api.dto.NewsDto;
import com.training.api.services.NewsService;
import com.training.api.utils.URL;

@RestController
@RequestMapping(value = "/news")
public class NewsController {

	@Autowired
	private NewsService service;

	@GetMapping
	public ResponseEntity<List<NewsDto>> findAll() {
		List<NewsDto> news = service.findAll();
		return ResponseEntity.ok().body(news);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<List<NewsDto>> findById(@PathVariable Long id) {
		List<NewsDto> byId = service.findById(id);
		return ResponseEntity.ok().body(byId);
	}
 
	@GetMapping(value = "/titlesearch")
	public List<NewsDto> findByTitleIs(@ModelAttribute("title") @RequestParam String title) {

		title = URL.decodeParam(title);
		List<NewsDto> byTitle = service.findByTitle(title);
		return byTitle;

	}

	/*
	 * @GetMapping(value = "/{id}/{category}") public CategoryDto
	 * findByCategory(@RequestParam("category") CategoryDto category) { NewsDto news
	 * = service.findByCategory(category); List<CategoryDto> byCategory =
	 * news.getCategory(); return byCategory.get(0); }
	 */
}
