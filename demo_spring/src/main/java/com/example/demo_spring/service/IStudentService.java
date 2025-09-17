package com.example.demo_spring.service;

import com.example.demo_spring.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
}
