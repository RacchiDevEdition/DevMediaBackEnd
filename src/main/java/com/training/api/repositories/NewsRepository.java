package com.training.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.api.models.News;

public interface NewsRepository extends JpaRepository<News, Long> {

	List<News> findByTitleContainingIgnoreCase(String title);

	@Query(nativeQuery = true, value = "SELECT * FROM tb_news WHERE title = ? ")
	List<News> searchTitle(String title);

}
