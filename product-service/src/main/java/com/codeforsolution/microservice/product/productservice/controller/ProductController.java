package com.codeforsolution.microservice.product.productservice.controller;

import com.codeforsolution.microservice.product.productservice.model.Product;
import com.codeforsolution.microservice.product.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
         return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveNewProduct(@RequestBody Product product ){
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<List<Product>> updateProduct(){
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<List<Product>> deleteProduct(){
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

}
