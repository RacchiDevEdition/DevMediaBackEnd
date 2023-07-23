package com.training.api.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.training.api.models.Category;
import com.training.api.models.News;

public class NewsDto {

	private Long id;
	private String title;
	private String content;
	private Set<Category> category = new HashSet<>();

	public NewsDto(News news) {
		this.id = news.getId();
		this.title = news.getTitle();
		this.content = news.getContent();
		this.category = news.getCategory();

	}
	
	
	public NewsDto() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public Set<Category> getCategory() {
		return category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewsDto other = (NewsDto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "NewsDto [id=" + id + ", title=" + title + ", content=" + content + ", category=" + category + "]";
	}

}
