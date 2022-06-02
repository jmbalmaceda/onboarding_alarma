package com.onboarding.vitalsigns.controller;

import com.onboarding.vitalsigns.entity.Person;
import com.onboarding.vitalsigns.exception.NotFoundException;
import com.onboarding.vitalsigns.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Person> add(@RequestBody Person person) {
        Person result = personRepository.save(person);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("{personId}")
    public ResponseEntity<Person> get(@PathVariable(name = "personId") Integer personId){
        Person result = personRepository.findById(personId).orElseThrow(() -> new NotFoundException(String.format("Persona con id %s no existe", personId)));
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Person>> getByName(@PathVariable(name = "name") String name){
        Person person = new Person();
        person.setName(name);
        Example e = Example.of(person);
        List<Person> result = personRepository.findAll(e);
        return ResponseEntity.ok().body(result);
    }
}
