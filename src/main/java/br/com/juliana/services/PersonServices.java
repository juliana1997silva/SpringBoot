package br.com.juliana.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.juliana.model.Person;

// serve para que o spring boot reconhece esse arquivo como um service
//é no arquivo services que é realizada a chamada ao banco de dados
@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Buscando uma pessoa");
        Person person =  new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Juliana");
        person.setLastName("Jesus");
        person.setAddress("Cotia - SP - Brasil");
        person.setGender("feminine");
        return person;
    }

    public List<Person> findAll(){
       
        List<Person> persons = new ArrayList<>();
        for(int i =0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person create(Person person) {
        return person;

    }

    public Person update(Person person) {
        return person;

    }

    public void delete(String id) {
        //return person;
    }

    private Person mockPerson(int i) {
        Person person =  new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Juliana" + i);
        person.setLastName("Jesus"+ i);
        person.setAddress("Cotia - SP - Brasil"+ i);
        person.setGender("feminine"+ i);
        return person;
    }

    

}
