package br.com.erudio.apigetway.Services;

import br.com.erudio.apigetway.Model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){

        logger.info("Find one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Lucas");
        person.setLastName("Magalhães");
        person.setAddress("Brasilia - Distrito Federal");
        person.setGender("Male");

        return person;
    }

}
