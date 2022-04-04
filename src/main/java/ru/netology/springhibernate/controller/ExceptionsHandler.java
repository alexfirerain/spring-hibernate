package ru.netology.springhibernate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.netology.springhibernate.exception.PersonNotFoundException;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> PNFHandler(PersonNotFoundException pnfe) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Одного такого не найдено: " + pnfe.getLocalizedMessage());
    }
}
