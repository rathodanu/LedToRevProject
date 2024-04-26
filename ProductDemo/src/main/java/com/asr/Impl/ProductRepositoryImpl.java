package com.asr.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comasr.Model.Product;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductRepositoryImpl {

    @Autowired
    private EntityManager entityManager;

    public List<Product> findAll() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

}
