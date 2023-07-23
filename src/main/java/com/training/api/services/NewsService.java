package com.training.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.api.dto.NewsDto;
import com.training.api.models.News;
import com.training.api.repositories.NewsRepository;

@Service
public class NewsService {

	@Autowired
	private NewsRepository repository;

	public List<NewsDto> findAll() {
		List<News> news = repository.findAll();
		List<NewsDto> findAll = news.stream().map(x -> new NewsDto(x)).toList();
		return findAll;
	}

	public NewsDto findById(Long id) {
		News news = repository.findById(id).get();
		NewsDto findById = new NewsDto(news);
		return findById;

	}

	public NewsDto findByTitle(String title) {

		List<News> news = repository.searchTitle(title);
		List<NewsDto> n1 = news.stream().map(x -> new NewsDto(x)).toList();
		for (NewsDto dto : n1) {
			if (dto.getTitle().equalsIgnoreCase(title)) {
				return dto;
			}
		}
		return null;
	}

	public NewsDto createNew(News news) {
		News dto = repository.save(news);
		NewsDto response = new NewsDto(dto);
		
		return response;
	}
}
