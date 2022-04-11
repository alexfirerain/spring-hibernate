package ru.netology.springhibernate.service;

import org.springframework.stereotype.Service;
import ru.netology.springhibernate.entity.Person;
import ru.netology.springhibernate.entity.Personality;
import ru.netology.springhibernate.exception.PersonNotFoundException;
import ru.netology.springhibernate.repository.PersonRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DatabaseService {
    private final PersonRepository personRepository;

    public DatabaseService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

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

    public Person save(Person personToSave) {
        return personRepository.save(personToSave);
    }

    public void delete(Personality personalityToRemove) {
        personRepository.deleteById(personalityToRemove);
    }

    public long count() {
        return personRepository.count();
    }

    public Person get(Personality id) throws PersonNotFoundException {
        Person x;
        try {
            x = personRepository.getById(id);
        } catch (EntityNotFoundException enfe) {
            throw new PersonNotFoundException("Такого лица не найдено. " + enfe.getMessage());
        }
        return x;
    }

    public List<Person> getByName(String name) {
        return personRepository.findByPhysicalEntityName(name);
    }
}
