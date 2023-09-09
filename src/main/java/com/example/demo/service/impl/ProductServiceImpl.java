package com.example.demo.service.impl;

import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void create(ProductEntity productEntity) {
        this.productRepository.save(productEntity);
    }

    @Override
    public void update(ProductEntity productEntityRequest, Long id) {
        ProductEntity productEntityDb = this.productRepository.findById(id).orElse(null);
        if (Objects.nonNull(productEntityDb)) {
            productEntityDb.setName(productEntityRequest.getName());
            productEntityDb.setPrice(productEntityRequest.getPrice());
            this.productRepository.save(productEntityDb);
        }
    }

    @Override
    public void delete(Long id) {
        ProductEntity productEntity = this.productRepository.findById(id).orElse(null);
        if (Objects.nonNull(productEntity)) {
            this.productRepository.delete(productEntity);
        }
    }

    @Override
    public List<ProductEntity> list() {
        return (List<ProductEntity>) this.productRepository.findAll();
    }
}
