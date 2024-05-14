package br.com.juliana.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.juliana.data.vo.v1.PersonVO;
import br.com.juliana.data.vo.v2.PersonVOV2;
import br.com.juliana.services.PersonServices;

@RestController
@RequestMapping("/api/person/v1")

public class PersonController {

    // com essa anotação o spring boot vai cuidar da instanciação
    @Autowired
    private PersonServices services;

    // retorna todos os registros
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll() {

        return services.findAll();
    }

    // retorna apenas um registro => registro do id informado na URL
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(@PathVariable(value = "id") @NonNull Long id) {

        return services.findById(id);
    }

    // registra um dado versão do VO 1
    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create(@RequestBody @NonNull PersonVO person) {
        return services.create(person);
    }

    // registra um dado versão do VO 2
    @PostMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOV2 create(@RequestBody @NonNull PersonVOV2 person) {
        return services.createV2(person);
    }

    // atualiza um dado
    @PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update(@RequestBody @NonNull PersonVO person) {
        return services.create(person);
    }

    // deleta um dado
    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") @NonNull Long id) {
       services.delete(id);
       //retorna o status 204
       
       return ResponseEntity.noContent().build();
    }

}
