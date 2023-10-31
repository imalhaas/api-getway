package br.com.erudio.apigetway.Services;

import br.com.erudio.apigetway.Exceptions.ResourceNotFoundException;
import br.com.erudio.apigetway.Mapper.DozerMapper;
import br.com.erudio.apigetway.Model.PersonVO;
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

    public List<PersonVO> findAll(){
        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){

        logger.info("Find one person!");
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found this id"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person){
        logger.info("Creating new person");

        return personRepository.save(person);
    }
    public PersonVO update(PersonVO person){
        logger.info("updating new person");

         PersonVO entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found this id"));

         entity.setFirstName(person.getFirstName());
         entity.setLastName(person.getLastName());
         entity.setAddress(person.getAddress());
         entity.setGender(person.getGender());

        return personRepository.save(person);
    }
    public void delete(Long id){
        logger.info("deleting one person");

        PersonVO entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found this id"));

        personRepository.delete(entity);
    }
}
