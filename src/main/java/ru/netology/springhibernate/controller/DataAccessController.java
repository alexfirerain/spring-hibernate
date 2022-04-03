package ru.netology.springhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springhibernate.entity.Person;
import ru.netology.springhibernate.entity.Personality;
import ru.netology.springhibernate.exception.PersonNotFoundException;
import ru.netology.springhibernate.service.DatabaseService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class DataAccessController {
    @Autowired
    private DatabaseService personsService;

    @GetMapping("/by-city")
    public List<Person> getByCity(@RequestParam String city) {
        return personsService.getByCity(city);
    }

    @GetMapping("/under-age")
    public List<Person> getUnderAge(@RequestParam int age) {
        return personsService.getYoungerThan(age);
    }

    @GetMapping("/by-full-name")
    public Person getByCity(@RequestParam String name, @RequestParam String surname) throws PersonNotFoundException {
        return personsService.getByFullName(name, surname);
    }

    @GetMapping("")
    public List<Person> showAll() {
        return personsService.showAll();
    }

    @GetMapping("/add")
    public void addAPerson(@RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam int age,
                           @RequestParam String phoneNumber,
                           @RequestParam String cityOfLiving) {
        personsService.save(new Person(new Personality(name, surname, age), phoneNumber, cityOfLiving));
    }

    @GetMapping("/delete")
    public void removeAPerson(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam int age) {
        personsService.delete(new Personality(name, surname, age));
    }

}
