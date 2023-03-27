package com.example.btvn_buoi3;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebController {

    @GetMapping({"/", "login"})
    public String index() {
        return "index";
    }

    @GetMapping("/store")
    public String store(Model model) {
        model.addAttribute("list",Store.userList);
        return "store";
    }

    @PostMapping("/store")
    public String store(@RequestParam("name") String name, @RequestParam("password") String password) {
        for (User item : Store.userList) {
            if (item.getName().equals(name) && item.getPassword().equals(password))
                return "redirect:store";
        }
        return "loginFailed";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signUp";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("fullname") String fullname) {
        for (User u : Store.userList) {
            if (u.getName().equals(name))
                return "signUpFailed";
        }

        Store.setId(Store.getId() + 1);
        Store.userList.add(new User(Store.getId(), name, password, fullname));
        return "redirect:login";
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> users() {
        return ResponseEntity.ok().body(Store.userList);
    }
}
