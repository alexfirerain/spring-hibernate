package ru.netology.springhibernate.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Person {

    @EmbeddedId
    private Personality physicalEntity;

    private String phoneNumber = "-";

    private String cityOfLiving;

}
