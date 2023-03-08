package com.example.testappspringboot.Controllers;

import com.example.testappspringboot.DTO.PersonDto;
import com.example.testappspringboot.Service.PersonServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

// INSERT INTO PERSON(ID, DATE_OF_BIRTH, NAME, SURNAME) VALUES (1, '2001-03-11', 'Mike', 'Smith')
// INSERT INTO PERSON(ID, DATE_OF_BIRTH, NAME, SURNAME) VALUES (2, '2003-04-08', 'Bob', 'Potter')
// INSERT INTO PERSON(ID, DATE_OF_BIRTH, NAME, SURNAME) VALUES (3, '2002-07-18', 'Garry', 'Parker')

@RestController
@EnableAutoConfiguration
public class MainController extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(MainController.class, args);
    }
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MainController.class);
    }

    private final PersonServiceImpl personServiceImpl;

    public MainController(PersonServiceImpl personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }

    @GetMapping("/person/{id}")
    public PersonDto getById(@PathVariable("id") Long id) {
        return personServiceImpl.getById(id);
    }

}
