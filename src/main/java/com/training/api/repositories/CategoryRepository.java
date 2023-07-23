package com.training.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.api.models.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM TB_CATEGORY WHERE ID = ?")
	List<Category> searchTitleByCategory(Long id);
}
