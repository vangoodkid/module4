package com.example.Blog.repository;


import com.example.Blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    Blog save(Blog blog);
    List<Blog> findAll();
    Optional<Blog> findById(Long id);
    void deleteById(Long id);
}
