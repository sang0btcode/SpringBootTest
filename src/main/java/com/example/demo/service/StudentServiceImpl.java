package com.example.demo.service;



import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service

public class StudentServiceImpl implements StudentService {

    @Autowired
 StudentRepository studentRepository;



    @Override
    public Student addStudent(Student student) {
        System.out.println(student);
        studentRepository.save(student);
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.deleteById(student.getId());
    }


    @Override
    public List<Student> getAll() {
        List<Student> s = null;
        s = studentRepository.findAll();
        System.out.println("s : " + s);
        return s;
    }

    @Override
    public Student getOne(Long id) {
        return studentRepository.getReferenceById(id);
    }

    @Override
    public String CalculatorAverageScore(Long id) {
        Student s = getOne(id);
        System.out.println(s);
        double a = (s.getMathScore()+ s.getEngllishScore() + s.getLiteratureScore())/3;
        return  s.getName() + "Bạn có điểm trung bình là: " + a;


    }

}
