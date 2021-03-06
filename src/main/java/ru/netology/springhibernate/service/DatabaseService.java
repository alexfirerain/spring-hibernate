package ru.netology.springhibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.springhibernate.entity.Person;
import ru.netology.springhibernate.repository.PersonsRepository;

import java.util.List;

@Service
public class DatabaseService {
    @Autowired
    private PersonsRepository personsRepository;

    public List<Person> getPersonsByCity(String city) {
        return personsRepository.getPersonsByCity(city);
    }
}
