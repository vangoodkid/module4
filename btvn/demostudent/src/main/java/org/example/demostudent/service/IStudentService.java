package org.example.demostudent.service;

import org.example.demostudent.entity.Student;

import java.util.List;

public  interface IStudentService {
    List<Student> findAll();

    Student findById(int id);
    boolean add(Student student);
}
