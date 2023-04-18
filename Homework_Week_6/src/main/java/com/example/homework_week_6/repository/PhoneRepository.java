package com.example.homework_week_6.repository;

import com.example.homework_week_6.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    @Transactional
    @Modifying
    @Query("update Phone p set p.name = ?2 where p.id = ?1")
    void updatePhone(Long id, String name);
}
