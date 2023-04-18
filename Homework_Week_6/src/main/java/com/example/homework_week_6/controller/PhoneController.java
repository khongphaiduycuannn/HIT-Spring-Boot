package com.example.homework_week_6.controller;

import com.example.homework_week_6.dto.PhoneDTO;
import com.example.homework_week_6.entity.Phone;
import com.example.homework_week_6.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("phone")
public class PhoneController {

    private final PhoneService phoneService;

    @PostMapping("/create")
    private ResponseEntity<?> createPhone(@RequestBody PhoneDTO phoneDTO) {
        Phone phone = phoneService.createPhone(phoneDTO);
        return ResponseEntity.ok(phone);
    }

    @GetMapping("/get")
    private ResponseEntity<?> getAllPhone() {
        List<Phone> phones = phoneService.getAllPhone();
        return ResponseEntity.ok(phones);
    }

    @PatchMapping("/update/{id}")
    private ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody PhoneDTO phoneDTO) {
        Phone phone = phoneService.updatePhoneById(id, phoneDTO);
        return ResponseEntity.ok(phone);
    }
}
