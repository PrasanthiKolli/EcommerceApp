package com.fse.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fse.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
