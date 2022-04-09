package ru.netology.springhibernate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.springhibernate.entity.Person;
import ru.netology.springhibernate.entity.Personality;
import ru.netology.springhibernate.exception.PersonNotFoundException;
import ru.netology.springhibernate.service.DatabaseService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class DataAccessController {
    private final DatabaseService personsService;

    public DataAccessController(DatabaseService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/by-city")
    public List<Person> getByCity(@RequestParam String city) throws PersonNotFoundException {
        List<Person> byCityFound = personsService.getByCity(city);
        if (byCityFound.isEmpty())
            throw new PersonNotFoundException("Лиц из города " + city + " не найдено!");
        return personsService.getByCity(city);
    }

    @GetMapping("/under-age")
    public List<Person> getUnderAge(@RequestParam int age) throws PersonNotFoundException {
        List<Person> youngerFound = personsService.getYoungerThan(age);
        if (youngerFound.isEmpty())
            throw new PersonNotFoundException("Не обнаружено никого моложе " + age + " лет!");
        return personsService.getYoungerThan(age);
    }

    @GetMapping("/by-full-name")
    public Person getByFullName(@RequestParam String name, @RequestParam String surname) throws PersonNotFoundException {
        return personsService.getByFullName(name, surname);
    }

    @GetMapping("")
    public List<Person> showAll() {
        return personsService.showAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/add")
    public String addAPerson(@RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam int age,
                           @RequestParam String phoneNumber,
                           @RequestParam String cityOfLiving) {
        return "Добавлено лицо:\n"
                + personsService.save(new Person
                            (new Personality(name, surname, age),
                            phoneNumber,
                            cityOfLiving));
    }

    @GetMapping("/delete")
    public String removeAPerson(@RequestParam String name,
                                @RequestParam String surname,
                                @RequestParam int age) {
        Personality idToDelete = new Personality(name, surname, age);
        personsService.delete(idToDelete);
        return "Удалено лицо: " + idToDelete;
    }

}
