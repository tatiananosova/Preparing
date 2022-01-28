package com.interview.preparing.homework7.controller;

import com.interview.preparing.homework7.model.Student;
import com.interview.preparing.homework7.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
@Log4j2
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    @ModelAttribute("students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @PostMapping
    public String create(@Valid @ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/student";
    }

    @GetMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/student";
    }
}
