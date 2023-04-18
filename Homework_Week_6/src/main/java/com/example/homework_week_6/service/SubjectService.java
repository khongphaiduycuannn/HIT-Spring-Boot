package com.example.homework_week_6.service;

import com.example.homework_week_6.dto.SubjectDTO;
import com.example.homework_week_6.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {

    public Subject createSubject(SubjectDTO subjectDTO);

    public List<Subject> findByStudentId(Long id);

    public List<Subject> getAllSubject();
}
