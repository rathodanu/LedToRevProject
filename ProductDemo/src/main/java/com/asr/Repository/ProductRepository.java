package com.asr.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comasr.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByNameContainingAndCategoriesContainingAndAttributesContaining(String name, String category,
			Map<String, String> attributes);
    
}

