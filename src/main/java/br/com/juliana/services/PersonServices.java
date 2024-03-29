package br.com.juliana.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import br.com.juliana.exceptions.ResourceNotFoundException;
import br.com.juliana.model.Person;
import br.com.juliana.repositories.PersonRepository;

// serve para que o spring boot reconhece esse arquivo como um service
//é no arquivo services que é realizada a chamada ao banco de dados
@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    // lista todos os registros
    public List<Person> findAll() {

        return repository.findAll();
    }

    // lista o registro com o ID informado
    public Person findById(@NonNull Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado"));
    }

    // cria um registro
    public Person create(@NonNull Person person) {
        return repository.save(person);

    }

    // atualiza o registro
    public Person update(Person person) {
        Long id = person.getId();

        // Verifica se o ID é nulo
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }

        var optionalEntity = repository.findById(id);

        if (optionalEntity.isPresent()) {

            var entity = optionalEntity.get();

            entity.setFirstName(person.getFirstName());
            entity.setLastName(person.getLastName());
            entity.setAddress(person.getAddress());
            entity.setGender(person.getGender());

            return repository.save(entity);

        } else {

            throw new ResourceNotFoundException("Nenhum registro encontrado");
        }
    }

    public void delete(@NonNull Long id) {
        // Ensure null safety by checking if findById returns null
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado"));
    
        // Add a null check to handle the case where findById returns null
        if (entity != null) {
            repository.delete(entity);
        } else {
            throw new ResourceNotFoundException("Nenhum registro encontrado");
        }
    }
}
