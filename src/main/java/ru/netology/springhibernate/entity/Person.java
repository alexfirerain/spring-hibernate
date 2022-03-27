package ru.netology.springhibernate.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.Valid;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Validated
public class Person {

    @Valid
    @EmbeddedId
    private Personality physicalEntity;

    private String phoneNumber = "-";

    private String cityOfLiving;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return physicalEntity != null && Objects.equals(physicalEntity, person.physicalEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(physicalEntity);
    }
}
