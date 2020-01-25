package com.pestana.springbootmongodb.datamongodb;

import com.pestana.springbootmongodb.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {

    public Student findByName(String name);
    public List<Student> findByScore(String score);

}
