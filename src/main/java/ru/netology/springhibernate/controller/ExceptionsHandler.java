package ru.netology.springhibernate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.netology.springhibernate.exception.PersonNotFoundException;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String NAUPEHandler(PersonNotFoundException naupe) {
        return "Одного такого не найдено: " + naupe.getLocalizedMessage();
    }
}
