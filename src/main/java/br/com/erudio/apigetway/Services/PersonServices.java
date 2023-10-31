package br.com.erudio.apigetway.Services;

import br.com.erudio.apigetway.Exceptions.ResourceNotFoundException;
import br.com.erudio.apigetway.Mapper.DozerMapper;
import br.com.erudio.apigetway.Model.Person;
import br.com.erudio.apigetway.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll(){

        logger.info("find all people");

        return DozerMapper.parseListObjects(personRepository.findAll(), Person.class);
    }

    public Person findById(Long id){

        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return DozerMapper.parseObject(entity, Person.class);
    }

    public Person create(Person person){
        logger.info("Creating new person");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(personRepository.save(person), Person.class);
        return vo;
    }

    public Person update(Person person){
        logger.info("updating new person");

         Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found this id"));

         entity.setFirstName(person.getFirstName());
         entity.setLastName(person.getLastName());
         entity.setAddress(person.getAddress());
         entity.setGender(person.getGender());
         var  vo = DozerMapper.parseObject(personRepository.save(person), Person.class);
        return vo;
    }

    public void delete(Long id){
        logger.info("deleting one person");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found this id"));

        personRepository.delete(entity);
    }
}
