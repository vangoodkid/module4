package com.example.demo_spring.repository;

import com.example.demo_spring.entity.Student;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {

    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"holyshit"));
    }
    @Override
    public  List<Student> findAll() {
        return studentList;
    }
}
