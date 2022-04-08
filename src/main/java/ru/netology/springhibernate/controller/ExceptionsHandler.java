package ru.netology.springhibernate.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.netology.springhibernate.exception.PersonNotFoundException;

@ControllerAdvice
public class ExceptionsHandler {

    private String getCurrentUserName() {
        return "Уважаемый " + SecurityContextHolder.getContext().getAuthentication().getName() + "!\n";
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> PNFHandler(PersonNotFoundException pnfe) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(getCurrentUserName() + "Данные не получены: " + pnfe.getLocalizedMessage());
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> PNFHandler(EmptyResultDataAccessException erdae) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(getCurrentUserName() + "Невозможно обработать запрос: " + erdae.getLocalizedMessage());
    }

    @ExceptionHandler(IncorrectResultSizeDataAccessException.class)
    public ResponseEntity<String> PNFHandler(IncorrectResultSizeDataAccessException irsde) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(getCurrentUserName() + "Неоднозначный запрос: " + irsde.getLocalizedMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> MSRPHandler(MissingServletRequestParameterException msrpe) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(getCurrentUserName() + "Передайте параметры согласно спецификации!\n" + msrpe.getLocalizedMessage());
    }

}
