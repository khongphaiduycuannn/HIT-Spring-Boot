package com.example.homework_week_6.controller;

import com.example.homework_week_6.dto.StudentDTO;
import com.example.homework_week_6.entity.Student;
import com.example.homework_week_6.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    private ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
        Student student = studentService.createStudent(studentDTO);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/get")
    private ResponseEntity<?> getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        return ResponseEntity.ok(students);
    }

    @PatchMapping("/update/{id}")
    private ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        Student student = studentService.updateStudentById(id, studentDTO);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> deleteById(@PathVariable Long id) {
        Student student = studentService.deleteStudentById(id);
        return ResponseEntity.ok(student);
    }
}
