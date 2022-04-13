package ru.netology.springhibernate.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springhibernate.entity.Person;
import ru.netology.springhibernate.entity.Personality;
import ru.netology.springhibernate.exception.PersonNotFoundException;
import ru.netology.springhibernate.service.DatabaseService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/service")
public class SecuredController {

    private final DatabaseService personsService;

    public SecuredController(DatabaseService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/count")
    @Secured("ROLE_READ")
    public String count() {
        return "Всего лиц в базе: " + personsService.count();
    }

    @GetMapping("/update")
    @RolesAllowed("ROLE_WRITE")
    public String update(@RequestParam(name = "name") String idName,
                         @RequestParam(name = "surname") String idSurname,
                         @RequestParam(name = "age") int idAge,
                         @RequestParam(name = "city", required = false) String newCity,
                         @RequestParam(name = "number", required = false) String newNumber) {
        Person changing = personsService.get(new Personality(idName, idSurname, idAge));

        if (newCity != null && !newCity.isBlank())
            changing.setCityOfLiving(newCity);
        if (newNumber != null && !newNumber.isBlank())
            changing.setPhoneNumber(newNumber);

        return "Обновлены данные: \n" + personsService.save(changing);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public List<Person> showAll() {
        return personsService.showAll();
    }

    @GetMapping("/by-name")
    @PreAuthorize("#username == authentication.principal.username")
    public List<Person> byNameSecured(@RequestParam String username,
                                      @RequestParam(name = "name") String queryName) {
        List<Person> theNamed = personsService.getByName(queryName);
        if (theNamed.isEmpty())
            throw new PersonNotFoundException("Нет никого, кто " + queryName + "!");
        return theNamed;
    }


}
