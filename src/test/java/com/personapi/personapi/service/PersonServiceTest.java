package com.personapi.personapi.service;

import com.personapi.personapi.controller.PersonController;
import com.personapi.personapi.dto.MessageResponseDTO;
import com.personapi.personapi.dto.request.PersonDTO;
import com.personapi.personapi.model.Person;
import com.personapi.personapi.repository.PersonRepository;
import com.personapi.personapi.util.PersonCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepositoryMock;

    @BeforeEach
    void setUp(){
        Person person = PersonCreator.createPerson();

        BDDMockito.when(personRepositoryMock.save(ArgumentMatchers.any())).thenReturn(person);
    }

    @Test
    @DisplayName("save persists person in database when successful")
    void save_PersistsPersonInDatabase_WhenSuccessful() {
        PersonDTO personDTO = PersonCreator.createPersonDTO();
        Person expectedSavedPerson = PersonCreator.createPerson();
        MessageResponseDTO expectedMessage = createExpectedMessageResponse(personDTO, expectedSavedPerson);

        MessageResponseDTO responseMessage = personService.save(personDTO);

        Assertions.assertThat(expectedMessage).isEqualTo(responseMessage);
        Assertions.assertThat(responseMessage).isInstanceOf(MessageResponseDTO.class);
        Assertions.assertThat(responseMessage).isNotNull();
    }

    private MessageResponseDTO createExpectedMessageResponse(PersonDTO personDTO, Person expectedSavedPerson) {
        return MessageResponseDTO.builder()
                .message("The person " + personDTO.getFirstName() + " " +  personDTO.getLastName() +
                        " was created with ID " + expectedSavedPerson.getId())
                .build();
    }
}