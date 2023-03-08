package com.example.testappspringboot.Service;

import com.example.testappspringboot.DTO.PersonDto;
import com.example.testappspringboot.Model.Person;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PersonServiceImpl {
    private final PersonService personService;

    public PersonServiceImpl(PersonService personService) {
        this.personService = personService;
    }

    public PersonDto getById(Long id) {
        var person = personService.getPersonById(id).orElseThrow();
        var age = countAgeByDateOfBirth(person);
        return new PersonDto(person.getName(), person.getSurname(), age);
    }
    private int countAgeByDateOfBirth(Person person) {
        return LocalDate.now().getYear() - person.getDateOfBirth().getYear();
    }
}
