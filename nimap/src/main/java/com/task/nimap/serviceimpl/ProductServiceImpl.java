package com.task.nimap.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.task.nimap.dto.ProductDto;
import com.task.nimap.mapper.ProductMapper;
import com.task.nimap.model.Category;
import com.task.nimap.model.Product;
import com.task.nimap.repo.CategoryRepo;
import com.task.nimap.repo.ProductRepo;
import com.task.nimap.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Page<ProductDto> getAllProducts(Pageable pageable) {
        return productRepo.findAll(pageable).map(ProductMapper::mapToProductDto);
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Category category = categoryRepo.findById(productDto.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + productDto.getCategory().getId()));

        Product product = ProductMapper.mapToProduct(productDto, category);
        Product savedProduct = productRepo.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());

        Category category = categoryRepo.findById(productDto.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + productDto.getCategory().getId()));

        product.setCategory(category);

        Product updatedProduct = productRepo.save(product);
        return ProductMapper.mapToProductDto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
