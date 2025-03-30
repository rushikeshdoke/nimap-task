package com.task.nimap.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.task.nimap.dto.ProductDto;

public interface ProductService {
    Page<ProductDto> getAllProducts(Pageable pageable);
    ProductDto getProductById(Long id);
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(Long id, ProductDto productDto);
    void deleteProduct(Long id);
}
