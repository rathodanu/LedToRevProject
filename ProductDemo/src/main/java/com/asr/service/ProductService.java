package com.asr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.asr.Repository.ProductRepository;

import comasr.Model.Product;
import comasr.Model.Rating;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProductById(id);
        if (existingProduct != null) {
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> searchProducts(String name, String category, Map<String, String> attributes) {
        // Implement search logic based on name, category, and attributes
        return productRepository.findByNameContainingAndCategoriesContainingAndAttributesContaining(name, category, attributes);
    }

    public Product rateProduct(Long id, Rating rating) {
        Product product = getProductById(id);
        if (product != null) {
            product.getRatings().add(rating);
            return productRepository.save(product);
        }
        return null;
    }

    public List<Product> sortProducts(String sortBy) {
        // Implement sorting logic based on sortBy parameter
        return productRepository.findAll(Sort.by(sortBy));
    }

    }



