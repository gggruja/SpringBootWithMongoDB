package com.goran.interv.play.service.mapper;

import com.goran.interv.play.api.dto.PersonDTO;
import com.goran.interv.play.service.annotation.Log;
import com.goran.interv.play.service.entity.Person;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonDTOMapper implements OrikaMapperFactoryConfigurer {


    @Log
    private static Logger log;

    @Override
    public void configure(MapperFactory orikaMapperFactory) {

        log.trace(
                "Initializing " + Person.class.getSimpleName() + " to" + PersonDTO.class.getSimpleName()
                        + " mapping.");

        orikaMapperFactory.classMap(Person.class, PersonDTO.class)
                .field("jmbg", "jmbg")
                .field("name", "name")
                .field("surname", "surname")
                .register();

    }
}
