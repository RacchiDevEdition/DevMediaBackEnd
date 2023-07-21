package com.training.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.training.api.models.News;

public class NewsDto {

	private Long id;
	private String title;
	private String content;
	private List<CategoryDto> category = new ArrayList<>();

	public NewsDto(News news) {
		this.id = news.getId();
		this.title = news.getTitle();
		this.content = news.getContent();

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

	public List<CategoryDto> getCategory() {
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
