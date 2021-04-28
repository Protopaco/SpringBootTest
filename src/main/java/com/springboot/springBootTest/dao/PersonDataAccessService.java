package com.springboot.springBootTest.dao;

import com.springboot.springBootTest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao{

    private final JdbcTemplate jdbcTemplate;

    RowMapper<Person> rowMapper = (resultSet, i) -> {
        UUID id = UUID.fromString(resultSet.getString("id"));
        String name = resultSet.getString("name");
        return new Person(id,name);
    };

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Person insertPerson(UUID newId, String newName) {
        final String sql = "INSERT INTO person VALUES ('" + newId + "', '" + newName + "') RETURNING *";
        return jdbcTemplate.queryForObject(sql, rowMapper);
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT id, name FROM person";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id = ?";

        Person person = jdbcTemplate.queryForObject(sql, rowMapper, id);

        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
