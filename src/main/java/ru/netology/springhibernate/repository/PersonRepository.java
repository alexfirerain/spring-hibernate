package ru.netology.springhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.springhibernate.entity.Person;
import ru.netology.springhibernate.entity.Personality;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Personality> {

    @Query("select p from Person p where p.cityOfLiving = :city")
    List<Person> findByCity(@Param("city") String city);

    @Query("select p from Person p where p.physicalEntity.age < :age")
    List<Person> findYoungerThanOrdered(@Param("age") int age);

    @Query("select p from Person p where p.physicalEntity.name = :name and p.physicalEntity.surname = :surname")
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

}
