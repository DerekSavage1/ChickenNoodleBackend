package online.ChewyN.ChickenNoodle.api;

import online.ChewyN.ChickenNoodle.model.Person;
import online.ChewyN.ChickenNoodle.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    //Controller is where we define HTTP methods
    //POST - add to server
    //GET - retrieve from server
    //PUT - Modify server
    //DELETE - remove from server

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping //We want this to be a POST request
    public void addPerson(@Valid @NonNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) { //The variable is created in the path
        return personService.getPersonByID(id)
                .orElse(null); //Can implement 404 user not found
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePersonById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") @Valid @NonNull UUID id, @RequestBody Person person) {
        personService.updatePerson(id, person);
    }
}
