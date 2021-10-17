package com.personapi.personapi.service;

import com.personapi.personapi.dto.MessageResponseDTO;
import com.personapi.personapi.model.Person;
import com.personapi.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO save(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder()
                .message("The person " + person.getFirstName() +
                        " " + person.getLastName() +
                        " was created with ID " + person.getId())
                .build();
    }
}
