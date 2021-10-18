package com.personapi.personapi.service;

import com.personapi.personapi.dto.MessageResponseDTO;
import com.personapi.personapi.dto.request.PersonDTO;
import com.personapi.personapi.exception.PersonNotFoundException;
import com.personapi.personapi.mapper.PersonMapper;
import com.personapi.personapi.model.Person;
import com.personapi.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO save(PersonDTO personDTO){
        Person personToSave = PersonMapper.INSTANCE.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder()
                .message("The person " + personDTO.getFirstName() +
                        " " + personDTO.getLastName() +
                        " was created with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.toDTO(person);

    }

    public void deleteById(Long id) throws PersonNotFoundException {
        PersonDTO personFound = findById(id);
        personRepository.deleteById(personFound.getId());
    }
}
