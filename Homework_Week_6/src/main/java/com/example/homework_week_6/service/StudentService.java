package com.example.homework_week_6.service;

import com.example.homework_week_6.dto.StudentDTO;
import com.example.homework_week_6.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public Student createStudent(StudentDTO studentDTO);

    public Student deleteStudentById(Long id);

    public Student updateStudentById(Long id, StudentDTO studentDTO);

    public List<Student> getAllStudent();
}
