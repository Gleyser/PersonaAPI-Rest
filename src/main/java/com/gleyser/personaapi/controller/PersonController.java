package com.gleyser.personaapi.controller;

import com.gleyser.personaapi.dto.request.PersonDTO;
import com.gleyser.personaapi.dto.response.MessageResponseDTO;
import com.gleyser.personaapi.exception.PersonNotFoundException;
import com.gleyser.personaapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService =personService;
}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return this.personService.createPerson(personDTO);


    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return this.personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO finById(@PathVariable Long id) throws PersonNotFoundException {
        return this.personService.findById(id);

    }
}


