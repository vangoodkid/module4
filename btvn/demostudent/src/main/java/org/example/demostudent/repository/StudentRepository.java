package org.example.demostudent.repository;

import org.example.demostudent.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {

    private static List<Student> studentList = new ArrayList<>();
    static {
//        studentList.add(new Student(1,"tuan1",true, Arrays.asList("java","js","php"),"C02"));
//        studentList.add(new Student(2,"tuan2",true, Arrays.asList("java","js","php"),"C02"));
//        studentList.add(new Student(3,"tuan3",true, Arrays.asList("java","js","php"),"C02"));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(int id) {
        for (Student student: studentList){
            if (id==student.getId()){
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean add(Student student) {
        return studentList.add(student);
    }
}

