package ru.netology.springhibernate.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springhibernate.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonsRepository {

    @PersistenceContext
    EntityManager personsDispatcher;

    public List<Person> getPersonsByCity(String city) {
        return personsDispatcher
                .createQuery("select p from Person p" +
                        " where p.cityOfLiving = :city_of_living",
                        Person.class)
                .setParameter("city_of_living", city)
                .getResultList();
    }
}
