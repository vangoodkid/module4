package com.example.shopping.service;


import com.example.shopping.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
}
