package com.init.products.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.products.entitys.Product;

public interface ProductDaos extends JpaRepository<Product, Long> {

	
}
