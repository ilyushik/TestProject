package com.example.testappspringboot.Service;

import com.example.testappspringboot.Model.Person;
import com.example.testappspringboot.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

}



