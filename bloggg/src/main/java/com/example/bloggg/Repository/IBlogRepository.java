package com.example.bloggg.Repository;

import com.example.bloggg.Entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    Blog save(Blog blog);
    Page<Blog> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);
    Optional<Blog> findById(Long id);
    void deleteById(Long id);
}
