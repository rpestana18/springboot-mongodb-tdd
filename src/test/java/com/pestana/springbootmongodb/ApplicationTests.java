package com.pestana.springbootmongodb;

import com.pestana.springbootmongodb.datamongodb.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = DataMongodbApplication.class)
@ExtendWith(SpringExtension.class)
public class ApplicationTests {


    @Test
    public void contextLoads() {
    }


}
