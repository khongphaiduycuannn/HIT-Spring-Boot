package com.example.homework_week_5.controller;

import com.example.homework_week_5.entity.User;
import com.example.homework_week_5.exception.NotFoundUserException;
import com.example.homework_week_5.exception.UserExistedException;
import com.example.homework_week_5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/create")
    private ResponseEntity<User> createUser(@RequestBody User user) {
        if (userRepository.findUserByUsername(user.getUsername()).isPresent()) {
            throw new UserExistedException("Haha", "Tài khoản đã tồn tại");
        }

        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/read")
    private ResponseEntity<ArrayList<User>> getUserList() {
        ArrayList<User> users = userRepository.getAllUser();
        if (users.isEmpty()) {
            throw new NotFoundUserException("Hehe", "Không tồn tại tài khoản");
        }

        return ResponseEntity.ok().body(users);
    }

    @PatchMapping("/update")
    private ResponseEntity<User> updateUser(@RequestBody User user) {
        if (userRepository.findUserById(user.getId()).isEmpty()) {
            throw new NotFoundUserException("Hehe", "Không tồn tại tài khoản");
        }

        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/delete")
    private ResponseEntity<User> deleteUser(@RequestBody User user) {
        System.out.println(user.getId());
        if (userRepository.findUserById(user.getId()).isEmpty()) {
            throw new NotFoundUserException("Hehe", "Không tồn tại tài khoản");
        }
        else {
            Optional<User> responseUser = userRepository.findUserById(user.getId());
            userRepository.deleteById(user.getId());

            return ResponseEntity.ok().body(responseUser.get());
        }
    }
}
