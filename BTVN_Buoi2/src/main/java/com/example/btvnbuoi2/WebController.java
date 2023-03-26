package com.example.btvnbuoi2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        Student[] list = {
                new Student("1010", "Nguyễn Duy Minh Quân", "CNTT", 19),
                new Student("0810", "Đỗ Danh Nghĩa", "CNTT", 19),
                new Student("1603", "Nguyễn Khắc Huy", "CNTT", 20),
                new Student("2712", "Nguyễn Hương Giang", "CNTT", 18),
                new Student("1603", "Nguyễn Thị Diệu Linh", "CNTT", 20)
        };
        model.addAttribute("list", list);
        return "about";
    }

    @PostMapping("/about")
    public String login(@RequestParam("account") String account, @RequestParam("password") String password) {
        if (account.equals("admin") && password.equals("1"))
            return "redirect:about";
        else return "about1";
    }
}
