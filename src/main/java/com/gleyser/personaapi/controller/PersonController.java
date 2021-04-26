package com.gleyser.personaapi.controller;

import com.gleyser.personaapi.dto.MessageResponseDTO;
import com.gleyser.personaapi.entity.Person;
import com.gleyser.personaapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {


    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person){
        Person savedPerson = this.personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + savedPerson.getId())
                .build();

    }
}
