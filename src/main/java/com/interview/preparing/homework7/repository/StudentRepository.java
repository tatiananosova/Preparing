package com.interview.preparing.homework7.repository;

import com.interview.preparing.homework7.model.Student;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private final List<Student> students = new CopyOnWriteArrayList<>();
    private final AtomicLong generator = new AtomicLong();

    @PostConstruct
    public void init() {
        students.addAll(List.of(
                new Student(generator.incrementAndGet(), "Jhon", 10),
                new Student(generator.incrementAndGet(), "Sam", 10),
                new Student(generator.incrementAndGet(), "Nick", 10)
        ));
    }

    public Student create(Student Student) {
        Student.setId(generator.incrementAndGet());
        students.add(Student);
        return Student;
    }

    public Student update(Student student) {
        if (student.getId() == null) {
            return null;
        }
        Student existingStudent = students.stream()
                .filter(it -> it.getId().equals(student.getId()))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        student.setId(existingStudent.getId());
        students.add(student);
        return student;
    }

    public int deleteById(long id) {
        List<Student> toDelete = students.stream()
                .filter(it -> it.getId().equals(id))
                .collect(Collectors.toList());
        return toDelete.size();
    }

    public List<Student> findAll() {
        return students.stream().toList();
    }
}
