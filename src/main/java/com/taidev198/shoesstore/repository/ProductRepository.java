package com.taidev198.shoesstore.repository;

import com.taidev198.shoesstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
