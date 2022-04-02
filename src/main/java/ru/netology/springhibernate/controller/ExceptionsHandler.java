package ru.netology.springhibernate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.netology.springhibernate.exception.NotAUniquePersonException;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NotAUniquePersonException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String NAUPEHandler(NotAUniquePersonException naupe) {
        return "Одного такого не найдено: " + naupe.getLocalizedMessage();
    }
}
