package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudent(){
        System.out.println("check");
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student = studentService.getOne(id);
        if (student != null){
            return new ResponseEntity<>(student, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException e) {
        // Xử lý ngoại lệ EntityNotFoundException
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity không được tìm thấy");
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        System.out.println(student);
        return studentService.addStudent(student);

    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestParam Long id, @RequestBody Student student){
        Student student1 = studentService.getOne(id);
        if (student1 != null){
            if (student.getName()!=null) student1.setName(student.getName());
            if (student.getAddress() != null) student1.setAddress(student.getAddress());
            if (student.getAge() != null) student1.setAge(student.getAge());
            if (student.getSex() != null) student1.setSex(student.getSex());
            if (student.getEngllishScore() != null) student1.setEngllishScore(student.getEngllishScore());
            if (student.getMathScore() != null) student1.setMathScore(student.getMathScore());
            if (student.getLiteratureScore() != null) student1.setLiteratureScore(student.getLiteratureScore());
            return new ResponseEntity<>(studentService.addStudent(student1), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Student id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/average")
    public String CalculatorAverageScore(@RequestParam Long id){
        String s = null;
        s = studentService.CalculatorAverageScore(id);
        return s;

    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity handleMissingParameter(MissingServletRequestParameterException ex) {
        return ResponseEntity.ok(Collections.singletonMap(-1, "Không có tham số " + ex.getParameterName()));
    }}




