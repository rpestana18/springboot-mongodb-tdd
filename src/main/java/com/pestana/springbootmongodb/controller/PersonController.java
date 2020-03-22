package com.pestana.springbootmongodb.controller;

import com.pestana.springbootmongodb.datamongodb.PersonRepository;
import com.pestana.springbootmongodb.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.core.Response;


import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

    private static final Logger logger = LogManager.getLogger(PersonController.class);

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/person/findall")
    public List<Person> findAll() {
        logger.info("Hello from Log4j 2 - num : {}", () -> "findAll");
        return personRepository.findAll();
    }

    public Response createPerson(@Valid final Person person){
        logger.info("Adding a new Person {0}", person);

        Person p = personRepository.insert(person);
        logger.info("Person added - num : {}", () -> "createPerson");
        return Response.status(Response.Status.OK).build();

    }
}