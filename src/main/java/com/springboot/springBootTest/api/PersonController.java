package com.springboot.springBootTest.api;

import com.springboot.springBootTest.model.Person;
import com.springboot.springBootTest.service.PersonService;

public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(Person person) {
        personService.addPerson(person);
    }
}
