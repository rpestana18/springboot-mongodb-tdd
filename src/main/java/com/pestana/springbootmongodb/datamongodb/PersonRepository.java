package com.pestana.springbootmongodb.datamongodb;

import com.pestana.springbootmongodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    public Person findByName(String name);
    public List<Person> findByEmail(String email);

}
