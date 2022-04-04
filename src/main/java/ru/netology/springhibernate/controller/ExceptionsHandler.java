package ru.netology.springhibernate.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.springhibernate.exception.PersonNotFoundException;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> PNFHandler(PersonNotFoundException pnfe) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Данные не получены: " + pnfe.getLocalizedMessage());
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> PNFHandler(EmptyResultDataAccessException erdae) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body("Невозможно обработать запрос: " + erdae.getLocalizedMessage());
    }

    @ExceptionHandler(IncorrectResultSizeDataAccessException.class)
    public ResponseEntity<String> PNFHandler(IncorrectResultSizeDataAccessException irsde) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body("Неоднозначный запрос: " + irsde.getLocalizedMessage());
    }


}
