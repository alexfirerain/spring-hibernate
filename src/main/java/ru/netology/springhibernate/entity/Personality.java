package ru.netology.springhibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@Validated
public class Personality implements Serializable {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Valid
    @Min(0)
    private int age;

}
