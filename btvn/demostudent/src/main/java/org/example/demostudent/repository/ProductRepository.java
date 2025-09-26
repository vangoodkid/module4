package org.example.demostudent.repository;

import jakarta.persistence.TypedQuery;
import org.example.demostudent.entity.Product;
import org.example.demostudent.utils.ConnectionUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class ProductRepository implements IProductRepository{


//    static {
//        products.add(new Product(1L, "Iphone 15", 1200, "Điện thoại Apple mới nhất", "Apple"));
//        products.add(new Product(2L, "Galaxy S24", 1100, "Điện thoại Samsung cao cấp", "Samsung"));
//        products.add(new Product(3L, "Xiaomi 14", 700, "Flagship giá rẻ", "Xiaomi"));
//    }

    @Override
    public List<Product> findAll() {
        List<Product> productList=new ArrayList<>();
        Session session= ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query=session.createQuery("from Product ");
        productList=query.getResultList();
        session.close();
        return productList;
    }

    @Override
    public Product findById(Long id) {
        Session session= ConnectionUtil.sessionFactory.openSession();
        Product product=session.find(Product.class,id);
        session.close();
        return product;
    }

    @Override
    public void save(Product product) {
        Session session= ConnectionUtil.sessionFactory.openSession();
        Transaction transaction=session.getTransaction();
        try{
            transaction.begin();
            session.persist(product);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
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

}

