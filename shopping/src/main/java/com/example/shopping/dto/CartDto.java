package com.example.shopping.dto;

import com.example.shopping.entity.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CartDto {
    private Map<Product, Integer> products = new HashMap<>();

    public CartDto() {
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (Objects.equals(entry.getKey().getId(), product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (Objects.equals(entry.getKey().getId(), product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            assert itemEntry != null;
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    public void changeQuantity(Product product, Integer quantity) {
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        if (itemEntry != null) {
            if (quantity > 0) {
                products.replace(itemEntry.getKey(), quantity);
            } else {
                products.remove(itemEntry.getKey());
            }
        }
    }

    public Double countTotalPayment() {
        double payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (double) entry.getValue();
        }
        return payment;
    }
}
