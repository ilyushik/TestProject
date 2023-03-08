package com.example.testappspringboot.Service;

import com.example.testappspringboot.DTO.PersonDto;
import com.example.testappspringboot.Model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {
    @Mock
    private PersonService personService;
    @InjectMocks
    private PersonServiceImpl personServiceImpl;
    @Test
    public void shouldReturnPersonById() {
        Long id = 1L;
        LocalDate dateOfBirth = LocalDate.of(2001, 03, 1);
        Person person = new Person("Mick", "Smith", dateOfBirth);
        Optional<Person> oPerson = Optional.of(person);
        when(personService.getPersonById(id)).thenReturn(oPerson);

        PersonDto expectedPerson = new PersonDto("Mick", "Smith", 22);
        PersonDto actualPerson = personServiceImpl.getById(id);

        Assertions.assertEquals(expectedPerson, actualPerson);
    }
}