package ru.netology.springhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springhibernate.service.DatabaseService;

import java.util.List;

@RestController
public class DataAccessController {
    @Autowired
    private DatabaseService personsService;

    @GetMapping("/persons/by-city")
    public List<String> getPersonsByCity(@RequestParam String city) {
        return personsService.getPersonsByCity(city);
    }
}
