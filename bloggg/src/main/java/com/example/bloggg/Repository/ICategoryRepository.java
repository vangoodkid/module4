package com.example.bloggg.Repository;

import com.example.bloggg.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {

}