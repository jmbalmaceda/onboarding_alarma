package com.onboarding.vitalsigns.controller;

import com.onboarding.vitalsigns.entity.Person;
import com.onboarding.vitalsigns.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Person result = personRepository.findById(personId).orElse(null);
        return ResponseEntity.ok().body(result);
    }
}
