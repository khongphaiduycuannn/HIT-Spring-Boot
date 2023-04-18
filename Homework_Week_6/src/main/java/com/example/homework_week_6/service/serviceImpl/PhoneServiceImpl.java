package com.example.homework_week_6.service.serviceImpl;

import com.example.homework_week_6.dto.PhoneDTO;
import com.example.homework_week_6.entity.Phone;
import com.example.homework_week_6.entity.Student;
import com.example.homework_week_6.exception.NotFoundIdException;
import com.example.homework_week_6.repository.PhoneRepository;
import com.example.homework_week_6.repository.StudentRepository;
import com.example.homework_week_6.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PhoneServiceImpl implements PhoneService {

    private final StudentRepository studentRepository;
    private final PhoneRepository phoneRepository;

    @Override
    public Phone createPhone(PhoneDTO phoneDTO) {
        Optional<Student> student = studentRepository.findById(phoneDTO.getStudentId());
        if (student.isEmpty())
            throw new NotFoundIdException("Not found student has id " + phoneDTO.getStudentId(), HttpStatus.FOUND);

        Phone phone = new Phone(null, phoneDTO.getName(), student.get());
        return phone;
    }

    @Override
    public Phone updatePhoneById(Long id, PhoneDTO phoneDTO) {
        Optional<Phone> phone = phoneRepository.findById(id);
        if (phone.isEmpty())
            throw new NotFoundIdException("Not found phone has id " + id, HttpStatus.NOT_FOUND);

        String name = phoneDTO.getName();
        phoneRepository.updatePhone(id, name);
        return phoneRepository.findById(id).get();
    }

    @Override
    public List<Phone> getAllPhone() {
        return phoneRepository.findAll();
    }
}
