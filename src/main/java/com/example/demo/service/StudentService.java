package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);

    List<Student> getAll();

    Student getOne(Long id);

    String CalculatorAverageScore(Long id);

}
