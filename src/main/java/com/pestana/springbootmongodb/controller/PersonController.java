package com.pestana.springbootmongodb.controller;

import com.pestana.springbootmongodb.datamongodb.PersonRepository;
import com.pestana.springbootmongodb.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class PersonController {

    private static final Logger logger = LogManager.getLogger(PersonController.class);

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/person/findall")
    public List<Person> findAll() {

        // model.addAttribute("tasks", num);
        //return "welcome"; //view
        logger.info("Hello from Log4j 2 - num : {}", () -> "findAll");
        return personRepository.findAll();

    }
}