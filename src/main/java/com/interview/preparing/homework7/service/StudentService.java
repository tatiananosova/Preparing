package com.interview.preparing.homework7.service;

import com.interview.preparing.homework7.model.Student;
import com.interview.preparing.homework7.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Long save(Student student) {
        if (student.getId() == null) {
            return studentRepository.create(student).getId();
        } else {
            return studentRepository.update(student).getId();
        }
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
