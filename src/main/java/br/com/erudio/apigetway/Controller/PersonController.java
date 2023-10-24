package br.com.erudio.apigetway.Controller;

import br.com.erudio.apigetway.Converter.NumberConverter;
import br.com.erudio.apigetway.Exceptions.UnsupportedMathOperationException;
import br.com.erudio.apigetway.Exceptions.Math.SimpleMath;
import br.com.erudio.apigetway.Model.Person;
import br.com.erudio.apigetway.Services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
   private PersonServices services;

    @RequestMapping(value="{id}", method=RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id) throws Exception {

        return services.findById(id);
    }
}
