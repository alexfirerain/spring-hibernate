package ru.netology.springhibernate.exception;

import java.util.function.Supplier;

public class PersonNotFoundException extends Exception implements Supplier<PersonNotFoundException> {
    public PersonNotFoundException(String message) {
        super(message);
    }

    @Override
    public PersonNotFoundException get() {
        return new PersonNotFoundException("Сгенерируем ошибку");
    }
}
