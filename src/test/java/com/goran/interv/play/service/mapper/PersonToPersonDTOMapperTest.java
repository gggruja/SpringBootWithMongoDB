package com.goran.interv.play.service.mapper;

import com.goran.interv.play.api.dto.PersonDTO;
import com.goran.interv.play.service.entity.Person;
import ma.glasnost.orika.MapperFacade;
import net.rakugakibox.spring.boot.orika.OrikaAutoConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class PersonToPersonDTOMapperTest {

    @Import({ OrikaAutoConfiguration.class })
    @TestConfiguration
    static class Configuration {

        @Bean
        public PersonToPersonDTOMapper converter() {

            return new PersonToPersonDTOMapper();
        }
    }

    @Autowired
    private MapperFacade mapperFacade;

    private static final String JMBG = "12345";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";

    private Person createPerson() {
        Person person = new Person();

        person.setJmbg(JMBG);
        person.setName(NAME);
        person.setSurname(SURNAME);

        return person;
    }

    private PersonDTO createPersonDTO() {
        PersonDTO personDTO = new PersonDTO();

        personDTO.setJmbg(JMBG);
        personDTO.setName(NAME);
        personDTO.setSurname(SURNAME);

        return personDTO;
    }

    @Test
    public void testMappingToDTO() {

        Person person = createPerson();

        // test call
        PersonDTO personDTO = mapperFacade.map(person, PersonDTO.class);

        assertThat(personDTO.getJmbg()).isEqualTo(JMBG);
        assertThat(personDTO.getName()).isEqualTo(NAME);
        assertThat(personDTO.getSurname()).isEqualTo(SURNAME);
    }

    @Test
    public void testMappingToEntity() {

        PersonDTO personDTO = createPersonDTO();

        // test call
        Person person = mapperFacade.map(personDTO, Person.class);

        assertThat(person.getJmbg()).isEqualTo(JMBG);
        assertThat(person.getName()).isEqualTo(NAME);
        assertThat(person.getSurname()).isEqualTo(SURNAME);
    }

}