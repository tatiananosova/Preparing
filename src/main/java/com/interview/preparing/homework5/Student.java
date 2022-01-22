package com.interview.preparing.homework5;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private int mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int price) {
        this.mark = price;
    }

    public Student() {
    }

    public Student(Long id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return String.format("SimpleItem [id = %d, name = %s, mark = %d]", id, name, mark);
    }
}

