package com.example.btvalidation.repository;

import com.example.btvalidation.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {
}