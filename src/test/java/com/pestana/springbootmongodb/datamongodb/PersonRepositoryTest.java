package com.pestana.springbootmongodb.datamongodb;

import com.pestana.springbootmongodb.ApplicationTests;
import com.pestana.springbootmongodb.model.Person;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Person Repository Methods")
@TestInstance(Lifecycle.PER_CLASS) // need to marc or set the repository instance with static
public class PersonRepositoryTest extends ApplicationTests {

    @Autowired
    PersonRepository repository;

    @BeforeAll
    void addAllPeople() {
        repository.save(new Person("Rodrigo", "rpestana@mail.com"));
        repository.save(new Person("Pedro", "pedro@mail.com"));
        System.out.println("All registers added.");
    }

    @AfterAll
    void removeAllPeople() {
        repository.deleteAll();
        System.out.println("All registers removed.");
    }

    @Test
    public void testFindByName() {
        System.out.println("People found with findbyName('Rodrigo'):");
        Person s = repository.findByName("Rodrigo");
        assertEquals("Rodrigo", s.getName());
        System.out.println(s);
    }

    @Test
    public void testFindByEmail() {
        System.out.println("People found with findByEmail('10'):");
        List<Person> list = repository.findByEmail("rpestana@mail.com");
        assertEquals(1, list.size());
        list.forEach(System.out::println);
    }
}