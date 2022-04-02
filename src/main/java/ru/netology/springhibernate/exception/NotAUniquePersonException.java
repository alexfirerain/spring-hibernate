package ru.netology.springhibernate.exception;

import java.util.function.Supplier;

public class NotAUniquePersonException extends Exception implements Supplier<NotAUniquePersonException> {
    public NotAUniquePersonException(String message) {
        super(message);
    }

    @Override
    public NotAUniquePersonException get() {
        return new NotAUniquePersonException("Сгенерируем ошибку");
    }
}
