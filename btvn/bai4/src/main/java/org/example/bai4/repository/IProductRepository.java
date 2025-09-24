package org.example.bai4.repository;

import org.example.bai4.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void update(Long id, Product product);
    void remove(Long id);
    List<Product> searchByName(String name);
}
