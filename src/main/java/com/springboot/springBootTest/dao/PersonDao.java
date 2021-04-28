package com.springboot.springBootTest.dao;

import com.springboot.springBootTest.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    Person insertPerson(UUID id, String name);

    default Person insertPerson(String name) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, name);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}
