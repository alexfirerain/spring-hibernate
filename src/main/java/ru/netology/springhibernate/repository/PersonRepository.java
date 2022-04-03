package ru.netology.springhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.springhibernate.entity.Person;
import ru.netology.springhibernate.entity.Personality;
import ru.netology.springhibernate.exception.PersonNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Personality> {

    List<Person> findByCityOfLiving(String city);

    List<Person> findByPhysicalEntityAgeLessThanOrderByPhysicalEntityAge(int age);

    Optional<Person> findByPhysicalEntityNameAndPhysicalEntitySurname(String name, String surname) throws PersonNotFoundException;

}
