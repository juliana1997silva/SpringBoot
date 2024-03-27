package br.com.juliana.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.juliana.model.Person;
import br.com.juliana.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

    // com essa anotação o spring boot vai cuidar da instanciação
    @Autowired
    private PersonServices services;

    // retorna todos os registros
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {

        return services.findAll();
    }

    // retorna apenas um registro => registro do id informado na URL
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id) {

        return services.findById(id);
    }

    // registra um dado
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return services.create(person);
    }

    // atualiza um dado
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return services.create(person);
    }

    // deleta um dado
    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable(value = "id") String id) {
       services.delete(id);
    }

}
