package org.example.demostudent.repository;

import org.example.demostudent.entity.Product;

import java.util.List;


public interface IProductRepository {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void update(Long id, Product product);
}
