package com.personapi.personapi.controller;

import com.personapi.personapi.dto.MessageResponseDTO;
import com.personapi.personapi.dto.request.PersonDTO;
import com.personapi.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO save(@Valid @RequestBody PersonDTO personDTO){
        return personService.save(personDTO);
    }
}
