package com.fse.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.fse.ecommerce.entity.Product;
import com.fse.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		HttpMethod[] theUnpportedActionss = { HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT };
		config.getExposureConfiguration()
				.forDomainType(Product.class)
				.withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnpportedActionss))
				.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnpportedActionss));
		
		config.getExposureConfiguration()
				.forDomainType(ProductCategory.class)
				.withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnpportedActionss))
				.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnpportedActionss));

	}

}
