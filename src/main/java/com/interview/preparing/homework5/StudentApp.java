package com.interview.preparing.homework5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentApp {
    private static SessionFactory factory;

    public static void init() {
        factory = new Configuration()
                .configure("homework5/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void showStudents() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            List<Student> students = session.createQuery("from Student").getResultList();
            System.out.println(students + "\n");

            Student student1 = session.createQuery("select s from Student s where s.id = 1", Student.class).getSingleResult();
            System.out.println(student1 + "\n");

            List<Student> lowMarkStudents = session.createQuery("select s from Student s where s.mark < 3").getResultList();
            System.out.println(lowMarkStudents + "\n");

            session.getTransaction().commit();
        }
    }

    public static void shutdown() {
        factory.close();
    }

    public static void addStudent(String name, int mark) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student student = new Student("Vasya", 4);
            session.save(student);
            session.getTransaction().commit();
        }
    }

    public static void printStudent(long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            System.out.println(student);
            session.getTransaction().commit();
        }
    }

    public static void updateStudent(long id, int mark) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            student.setMark(mark);
            session.getTransaction().commit();
        }
    }

    public static void deleteStudent(long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
        }
    }

    public static void main(String[] args) {
        try {
            init();
            showStudents();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }
}
