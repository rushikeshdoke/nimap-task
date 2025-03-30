package com.task.nimap.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.task.nimap.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {}
