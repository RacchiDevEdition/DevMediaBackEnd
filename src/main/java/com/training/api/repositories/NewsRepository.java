package com.training.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.api.models.News;

public interface NewsRepository extends JpaRepository<News, Long> {

	List<News> findByTitleContainingIgnoreCase(String title);
	// News findByCategory(CategoryDto category);

	@Query(nativeQuery = true, value = "SELECT * FROM tb_news WHERE title = ?1 ")
	List<News> searchTitle(String title);
}
