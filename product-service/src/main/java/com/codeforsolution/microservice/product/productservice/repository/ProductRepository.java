package com.codeforsolution.microservice.product.productservice.repository;

import com.codeforsolution.microservice.product.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
