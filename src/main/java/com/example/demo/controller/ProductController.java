package com.example.demo.controller;

import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
import com.example.demo.vo.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseMessage<Void> create(@RequestBody ProductEntity request) {
        this.productService.create(request);
        return new ResponseMessage<Void>().success();
    }

    @PostMapping("/update/{id}")
    public ResponseMessage<Void> update(@RequestBody ProductEntity request, @PathVariable Long id) {
        this.productService.update(request, id);
        return new ResponseMessage<Void>().success();
    }

    @PostMapping("/delete/{id}")
    public ResponseMessage<Void> delete(@PathVariable Long id) {
        this.productService.delete(id);
        return new ResponseMessage<Void>().success();
    }

    @PostMapping("/list")
    public ResponseMessage<List<ProductEntity>> list() {
        return new ResponseMessage<List<ProductEntity>>().body(this.productService.list()).success();
    }


}
