package ru.netology.springhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.springhibernate.entity.Person;
import ru.netology.springhibernate.entity.Personality;

public interface PersonRepository extends JpaRepository<Person, Personality> {

}
