package br.com.erudio.apigetway.Services;

import br.com.erudio.apigetway.Exceptions.ResourceNotFoundException;
import br.com.erudio.apigetway.Model.Person;
import br.com.erudio.apigetway.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findById(Long id){

        logger.info("Find one person!");
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found this id"));
    }

    public Person create(Person person){
        logger.info("Creating new person");

        return personRepository.save(person);
    }
    public Person update(Person person){
        logger.info("updating new person");

         Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found this id"));

         entity.setFirstName(person.getFirstName());
         entity.setLastName(person.getLastName());
         entity.setAddress(person.getAddress());
         entity.setGender(person.getGender());

        return personRepository.save(person);
    }
    public void delete(Long id){
        logger.info("deleting one person");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found this id"));

        personRepository.delete(entity);
    }
}
