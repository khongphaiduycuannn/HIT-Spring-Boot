package com.example.homework_week_6.service.serviceImpl;

import com.example.homework_week_6.dto.StudentDTO;
import com.example.homework_week_6.entity.Student;
import com.example.homework_week_6.exception.NotFoundIdException;
import com.example.homework_week_6.repository.StudentRepository;
import com.example.homework_week_6.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(StudentDTO studentDTO) {
        Student student = new Student(null, studentDTO.getName(), null, null);
        return student;
    }

    @Override
    public Student deleteStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty())
            throw new NotFoundIdException("Not found student has id " + id, HttpStatus.NOT_FOUND);

        studentRepository.deleteById(id);
        return student.get();
    }

    @Override
    public Student updateStudentById(Long id, StudentDTO studentDTO) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty())
            throw new NotFoundIdException("Not found student has id " + id, HttpStatus.NOT_FOUND);

        String name = studentDTO.getName();
        studentRepository.updateStudent(id, name);
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
