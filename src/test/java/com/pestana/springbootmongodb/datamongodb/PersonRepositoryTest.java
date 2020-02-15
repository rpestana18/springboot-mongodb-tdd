package com.pestana.springbootmongodb.datamongodb;

import com.pestana.springbootmongodb.ApplicationTests;
import com.pestana.springbootmongodb.controller.PersonControllerTest;
import com.pestana.springbootmongodb.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Person Repository Methods")
@TestInstance(Lifecycle.PER_CLASS) // need to marc or set the repository instance with static
public class PersonRepositoryTest extends ApplicationTests {

    private static final Logger logger = LogManager.getLogger(PersonRepositoryTest.class);

    @Autowired
    PersonRepository repository;

    @BeforeAll
    void addAllPeople() {
        repository.save(new Person("Rodrigo", "rpestana@mail.com"));
        repository.save(new Person("Pedro", "pedro@mail.com"));
        logger.info("All registers added.");
    }

    @AfterAll
    void removeAllPeople() {
        repository.deleteAll();
        logger.info("All registers removed.");
    }

    @Test
    public void testFindByName() {
        logger.info("People found with findbyName('Rodrigo'):");
        Person s = repository.findByName("Rodrigo");
        assertEquals("Rodrigo", s.getName());
        logger.info(s);
    }

    @Test
    public void testFindByEmail() {
        logger.info("People found with findByEmail('rpestana@mail.com'):");
        List<Person> list = repository.findByEmail("rpestana@mail.com");
        assertEquals(1, list.size());
        list.forEach(System.out::println);
    }
}