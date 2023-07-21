package com.training.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.training.api.models.Category;

public class CategoryDto {

	private Long id;
	private String name;

	private List<NewsDto> news = new ArrayList<>();

	public CategoryDto(Category category) {
		super();
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

	public List<NewsDto> getNews() {
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
