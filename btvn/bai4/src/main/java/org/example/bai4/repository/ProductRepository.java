package org.example.bai4.repository;

import org.example.bai4.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductRepository implements IProductRepository{
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1L, "Iphone 15", 1200, "Điện thoại Apple mới nhất", "Apple"));
        products.add(new Product(2L, "Galaxy S24", 1100, "Điện thoại Samsung cao cấp", "Samsung"));
        products.add(new Product(3L, "Xiaomi 14", 700, "Flagship giá rẻ", "Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void save(Product product) {
        product.setId((long) (products.size() + 1));
        products.add(product);
    }

    @Override
    public void update(Long id, Product product) {
        Product old = findById(id);
        if (old != null) {
            old.setName(product.getName());
            old.setPrice(product.getPrice());
            old.setDescription(product.getDescription());
            old.setManufacturer(product.getManufacturer());
        }
    }

    @Override
    public void remove(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public List<Product> searchByName(String name) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
