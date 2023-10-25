package br.com.erudio.apigetway.Controller;
import br.com.erudio.apigetway.Model.Person;
import br.com.erudio.apigetway.Services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
   private PersonServices services;

    @RequestMapping(value="{id}", method=RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") Long id) {
        return services.findById(id);
    }
    @RequestMapping( method=RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create (@RequestBody Person person) {
        return services.create(person);
    }
    @RequestMapping(value = "{id}", method=RequestMethod.PUT,
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update (@RequestBody Person person) {
        return services.update(person);
    }

    @RequestMapping(value = "{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable(value = "id") Long id) {
        services.delete(id);
    }

    @RequestMapping(method=RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        return services.findAll();
    }
}
