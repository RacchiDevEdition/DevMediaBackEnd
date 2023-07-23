package com.training.api.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.training.api.models.Category;
import com.training.api.models.News;

public class CategoryDto {

	private Long id;
	private String name;

	private Set<News> news = new HashSet<>();

	public CategoryDto(Category category) {
		this.id = category.getId();
		this.name = category.getName();
	}

	public CategoryDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<News> getNews() {
		return news;
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
		CategoryDto other = (CategoryDto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + "]";
	}

}
