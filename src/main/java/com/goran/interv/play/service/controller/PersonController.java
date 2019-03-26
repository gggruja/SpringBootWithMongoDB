package com.goran.interv.play.service.controller;

import com.goran.interv.play.api.PersonService;
import com.goran.interv.play.api.dto.PersonDTO;
import com.goran.interv.play.service.bussiness.service.PersonBussinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@Api(value = "play-person", description = "Person controller")
public class PersonController implements PersonService {

    @Autowired
    private PersonBussinessService personBussinessService;

    @ApiOperation(value = "Retrieves all persons by name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully read Person", response = PersonDTO.class),
            @ApiResponse(code = 400, message = "Invalid input"),
            @ApiResponse(code = 401, message = "You are not authorized to view persons"),
            @ApiResponse(code = 403, message = "Accessing the person you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The person you were trying to reach are not found"),
            @ApiResponse(code = 500, message = "We encountered an internal error. Please try again")
    })
    @Override
    public ResponseEntity<PersonDTO> getPersonByJmbg(@PathVariable("jmbg") String jmbg) {
        PersonDTO person = personBussinessService.getPersonByJmbg(jmbg);
        return ResponseEntity.ok(person);
    }

    @ApiOperation(value = "Create new Person")
    @Override public ResponseEntity<Void> createPerson(PersonDTO personDTO) {
        personBussinessService.createPerson(personDTO);
        return ResponseEntity.ok(null);
    }
}
