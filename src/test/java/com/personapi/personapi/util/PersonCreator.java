package com.personapi.personapi.util;

import com.personapi.personapi.dto.request.PersonDTO;
import com.personapi.personapi.model.Person;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Collections;

public class PersonCreator {
    private static final String FIRST_NAME = "Alan";
    private static final String LAST_NAME = "Pinho";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final Long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 10);

    public static PersonDTO createPersonDTO(){
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("20-10-2010")
                .phones(Collections.singletonList(PhoneCreator.createPhoneDTO()))
                .build();
    }

    public static Person createPerson(){
        return Person.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .id(PERSON_ID)
                .birthDate(BIRTH_DATE)
                .build();
    }
}
