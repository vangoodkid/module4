package com.example.btvalidation.service;

import com.example.btvalidation.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song save(Song song);
    Song findById(int id);
}