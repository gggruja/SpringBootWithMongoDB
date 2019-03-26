package com.goran.interv.play.service.bussiness.service.impl;

import com.goran.interv.play.api.dto.PersonDTO;
import com.goran.interv.play.service.annotation.Log;
import com.goran.interv.play.service.bussiness.service.PersonBussinessService;
import com.goran.interv.play.service.entity.Person;
import com.goran.interv.play.service.repository.PersonRepository;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class PersonBussinessServiceImpl implements PersonBussinessService {

    @Log
    private static Logger log;

    @Autowired
    MapperFacade mapper;

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonDTO getPersonByJmbg(String jmbg) {

        log.info("Try to find person with JMBG: {}",jmbg);

        Person byJMBG = personRepository.findByJmbg(jmbg);
        if (byJMBG == null){
            log.warn("No person with with JMBG: {}",jmbg);
            return null;
        }
        return mapper.map(byJMBG, PersonDTO.class);
    }

    @Override
    public void createPerson(PersonDTO personDTO) {
        Person person = mapper.map(personDTO, Person.class);
        Assert.notNull(person, "There is no person to create");
        personRepository.save(person);

    }
}
