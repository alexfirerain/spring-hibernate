package ru.netology.springhibernate.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonsRepository {

    @PersistenceContext
    EntityManager personsDispatcher;

    public List<String> getPersonsByCity(String city) {
        return null;
    }
}
