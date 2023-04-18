package com.example.homework_week_6.service;

import com.example.homework_week_6.dto.PhoneDTO;
import com.example.homework_week_6.entity.Phone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhoneService {

    public Phone createPhone(PhoneDTO phoneDTO);

    public Phone updatePhoneById(Long id, PhoneDTO phoneDTO);

    public List<Phone> getAllPhone();
}
