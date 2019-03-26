package com.goran.interv.play.api;

import com.goran.interv.play.api.dto.PersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PersonService {

    String URI = "/persons";

    @GetMapping(value = URI + "/{jmbg}")
    ResponseEntity<PersonDTO> getPersonByJmbg(@PathVariable("jmbg") String jmbg);

    @PostMapping(value = URI)
    ResponseEntity<Void> createPerson(@RequestBody PersonDTO personDTO);

}
