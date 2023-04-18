package com.example.homework_week_6.repository;

import com.example.homework_week_6.dto.StudentDTO;
import com.example.homework_week_6.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Transactional
    @Modifying
    @Query("update Student s set s.name = ?2 where s.id = ?1")
    void updateStudent(Long id, String name);
}
