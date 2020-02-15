package com.pestana.springbootmongodb.controller;

import com.pestana.springbootmongodb.ApplicationTests;
import com.pestana.springbootmongodb.datamongodb.PersonRepository;
import com.pestana.springbootmongodb.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Person Controller Methods")
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // need to marc or set the repository instance with static
public class PersonControllerTest extends ApplicationTests {

    private static final Logger logger = LogManager.getLogger(PersonControllerTest.class);

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
    public void findAllPersonTest() {
        logger.info("findAllPersonTest from Log4j 2 ", () -> "findAllPersonTest");
        List<Person> list = repository.findAll();
        assertEquals(2, list.size());
        list.forEach(System.out::println);
    }
}
