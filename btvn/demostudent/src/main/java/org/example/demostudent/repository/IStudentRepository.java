package org.example.demostudent.repository;

import org.example.demostudent.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(int id);
    boolean add(Student student);

}
