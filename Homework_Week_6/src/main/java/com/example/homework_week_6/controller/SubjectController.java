package com.example.homework_week_6.controller;

import com.example.homework_week_6.dto.SubjectDTO;
import com.example.homework_week_6.entity.Subject;
import com.example.homework_week_6.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("subject")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("/create")
    public ResponseEntity<?> createSubject(@RequestBody SubjectDTO subjectDTO) {
        Subject subject = subjectService.createSubject(subjectDTO);
        return ResponseEntity.ok(subject);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllSubject() {
        List<Subject> subjects = subjectService.getAllSubject();
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getByStudentId(@PathVariable Long id) {
        List<Subject> subjects = subjectService.findByStudentId(id);
        return ResponseEntity.ok(subjects);
    }
}
