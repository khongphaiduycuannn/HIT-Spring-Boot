package com.example.homework_week_5.controller;

import com.example.homework_week_5.entity.User;
import com.example.homework_week_5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class WebController {

    private final UserRepository userRepository;

    @GetMapping("/login")
    private String index() {
        return "login";
    }

    @PostMapping("/login")
    private String login(@RequestParam String username, @RequestParam String password) {
        Optional<User> tempUser = userRepository.findUserByUsername(username);
        if (tempUser.isEmpty() || !password.equals(tempUser.get().getPassword()))
            return "login";
        return "redirect:store";
    }

    @GetMapping("/store")
    private String store(Model model) {
        model.addAttribute("users", userRepository.getAllUser());
        return "store";
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> users() {
        return ResponseEntity.ok().body(userRepository.getAllUser());
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username, @RequestParam String password) {
        Optional<User> tempUser = userRepository.findUserByUsername(username);
        if (tempUser.isPresent() || password.equals(""))
            return "signup";

        User newUser = new User(null, username, password);
        userRepository.save(newUser);
        return "redirect:login";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<User> tempUser = userRepository.findUserById(id);
        model.addAttribute("user", tempUser.get());
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @RequestParam String username, @RequestParam String password) {
        if (!(username.equals("") || password.equals("")))
            userRepository.updateUser(username, password);
        return "redirect:/store";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/store";
    }
}
