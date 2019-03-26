package com.goran.interv.play.service.bussiness.service;

import com.goran.interv.play.api.dto.PersonDTO;

public interface PersonBussinessService {

    PersonDTO getPersonByJmbg(String jmbg);

    void createPerson(PersonDTO personDTO);

}
