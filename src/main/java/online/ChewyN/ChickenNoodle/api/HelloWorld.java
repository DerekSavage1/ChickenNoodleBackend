package online.ChewyN.ChickenNoodle.api;

import online.ChewyN.ChickenNoodle.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RequestMapping("/")
@RestController
public class HelloWorld {

    @GetMapping("/")
    public String hello () {
        return "Hello World!";
    }

}
