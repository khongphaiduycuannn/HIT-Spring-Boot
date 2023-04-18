package com.example.homework_week_6.service.serviceImpl;

import com.example.homework_week_6.dto.SubjectDTO;
import com.example.homework_week_6.entity.Student;
import com.example.homework_week_6.entity.Subject;
import com.example.homework_week_6.exception.NotFoundIdException;
import com.example.homework_week_6.repository.StudentRepository;
import com.example.homework_week_6.repository.SubjectRepository;
import com.example.homework_week_6.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class SubjectServiceImpl implements SubjectService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Override
    public Subject createSubject(SubjectDTO subjectDTO) {
        Optional<Student> student = studentRepository.findById(subjectDTO.getStudentId());
        if (student.isEmpty())
            throw new NotFoundIdException("Not found student has id " + subjectDTO.getStudentId(), HttpStatus.NOT_FOUND);

        Subject subject = new Subject(null, subjectDTO.getName(), student.get());
        return subject;
    }

    @Override
    public List<Subject> findByStudentId(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty())
            throw new NotFoundIdException("Not found student has id " + id, HttpStatus.NOT_FOUND);

        List<Subject> subjects = subjectRepository.findAllById(Collections.singleton(id));
        if (subjects.isEmpty())
            throw new NotFoundIdException("Not found subjects of student id " + id, HttpStatus.NOT_FOUND);

        return subjects;
    }

    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }
}
