package com.example.demo.service;

import com.example.demo.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    void create(ProductEntity productEntity);
    void update(ProductEntity productEntity, Long id);
    void delete(Long id);
    List<ProductEntity> list();
}
