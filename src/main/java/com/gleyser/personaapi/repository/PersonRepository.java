package com.gleyser.personaapi.repository;

import com.gleyser.personaapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
