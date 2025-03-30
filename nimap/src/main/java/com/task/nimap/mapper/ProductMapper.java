package com.task.nimap.mapper;

import com.task.nimap.dto.ProductDto;
import com.task.nimap.dto.CategoryDto;
import com.task.nimap.model.Product;
import com.task.nimap.model.Category;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                new CategoryDto(product.getCategory().getId(), product.getCategory().getName())
        );
    }

    public static Product mapToProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        return product;
    }
}
