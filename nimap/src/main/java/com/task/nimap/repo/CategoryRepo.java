package com.task.nimap.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.task.nimap.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {}
