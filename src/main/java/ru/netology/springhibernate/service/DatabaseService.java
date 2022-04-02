package ru.netology.springhibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.springhibernate.entity.Person;
import ru.netology.springhibernate.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersonsByCity(String city) {
        return personRepository.findByCityOfLiving(city);
    }

    public List<Person> getYoungerThan(int age) {
        return personRepository.findByPhysicalEntityAgeLessThan(age);
    }

    public Optional<Person> getByFullName(String name, String surname) {
        return personRepository.findByPhysicalEntityNameAndPhysicalEntitySurname(name, surname);
    }
}
