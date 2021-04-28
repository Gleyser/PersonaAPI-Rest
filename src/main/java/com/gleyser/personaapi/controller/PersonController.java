package com.gleyser.personaapi.controller;

import com.gleyser.personaapi.dto.MessageResponseDTO;
import com.gleyser.personaapi.entity.Person;
import com.gleyser.personaapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return this.personService.createPerson(person);


    }
}
