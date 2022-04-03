package ru.netology.springhibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.springhibernate.entity.Person;
import ru.netology.springhibernate.entity.Personality;
import ru.netology.springhibernate.exception.PersonNotFoundException;
import ru.netology.springhibernate.repository.PersonRepository;

import java.util.List;

@Service
public class DatabaseService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getByCity(String city) {
        return personRepository.findByCityOfLiving(city);
    }

    public List<Person> getYoungerThan(int age) {
        return personRepository.findByPhysicalEntityAgeLessThanOrderByPhysicalEntityAge(age);
    }

    public Person getByFullName(String name, String surname) throws PersonNotFoundException {
        return personRepository.findByPhysicalEntityNameAndPhysicalEntitySurname(name, surname)
                .orElseThrow(() -> new PersonNotFoundException("Лицо не найдено."));
    }

    public List<Person> showAll() {
        return personRepository.findAll();
    }

    public void save(Person personToAdd) {
        personRepository.save(personToAdd);
    }

    public void delete(Personality personalityToRemove) {
        personRepository.deleteById(personalityToRemove);
    }
}
