package com.training.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.api.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
