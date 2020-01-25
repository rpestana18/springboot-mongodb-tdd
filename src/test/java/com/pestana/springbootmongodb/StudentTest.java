package com.pestana.springbootmongodb;

import com.pestana.springbootmongodb.datamongodb.StudentRepository;
import com.pestana.springbootmongodb.model.Student;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest extends ApplicationTests {

    @Autowired
    StudentRepository repository;

    @BeforeEach
    void addAllStudents() {
        repository.save(new Student("Rodrigo", "10"));
        repository.save(new Student("Pedro", "9"));
        System.out.println("All registers added.");
    }

    @AfterEach
    void removeAllStudents() {
        repository.deleteAll();
        System.out.println("All registers removed.");
    }

    @Test
    public void testFindAll() {

        System.out.println("Student found with findAll():");
        System.out.println("-------------------------------");
        List<Student> list = repository.findAll();
        assertEquals(2, list.size());
        list.forEach(System.out::println);
    }

    @Test
    public void testFindByName() {

        System.out.println("Student found with findbyName('Rodrigo'):");
        System.out.println("--------------------------------");
        Student s = repository.findByName("Rodrigo");
        assertEquals("Rodrigo", s.getName());
        System.out.println(s);
    }

    @Test
    public void testFindByScore() {

        System.out.println("Students found with findByScore('10'):");
        List<Student> list = repository.findByScore("10");
        assertEquals(1, list.size());
        list.forEach(System.out::println);
    }
}
