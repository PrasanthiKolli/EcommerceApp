package com.fse.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fse.ecommerce.entity.ProductCategory;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ProductCategory", path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
