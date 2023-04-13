package com.example.homework_week_5.repository;

import com.example.homework_week_5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users", nativeQuery = true)
    ArrayList<User> getAllUser();

    @Query(value = "select * from users where id = ?1", nativeQuery = true)
    Optional<User> findUserById(Long id);

    @Query(value = "select * from users where username = ?1", nativeQuery = true)
    Optional<User> findUserByUsername(String username);

    @Transactional
    @Modifying
    @Query("update User u set u.password = ?2 where u.username = ?1")
    void updateUser(String username, String password);

}
