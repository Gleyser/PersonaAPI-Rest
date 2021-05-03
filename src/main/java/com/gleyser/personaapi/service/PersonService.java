package com.gleyser.personaapi.service;

import com.gleyser.personaapi.dto.request.PersonDTO;
import com.gleyser.personaapi.dto.response.MessageResponseDTO;
import com.gleyser.personaapi.entity.Person;
import com.gleyser.personaapi.mapper.PersonMapper;
import com.gleyser.personaapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = this.personMapper.toModel(personDTO);
        Person savedPerson = this.personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + savedPerson.getId())
                .build();

    }

    public List<PersonDTO> listAll(){
        List<Person> allPeople = this.personRepository.findAll();
        return allPeople.stream()
                .map(this.personMapper::toDTO)
                .collect(Collectors.toList());

    }


}
