package com.task.nimap.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.task.nimap.dto.CategoryDto;

public interface CategoryService {
    Page<CategoryDto> getAllCategories(Pageable pageable);
    CategoryDto getCategoryById(Long id);
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(Long id, CategoryDto categoryDto);
    void deleteCategory(Long id);
}
