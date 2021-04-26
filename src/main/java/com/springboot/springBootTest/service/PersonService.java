package com.springboot.springBootTest.service;

import com.springboot.springBootTest.dao.PersonDao;
import com.springboot.springBootTest.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
}
