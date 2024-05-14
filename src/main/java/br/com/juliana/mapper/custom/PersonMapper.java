package br.com.juliana.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.juliana.data.vo.v2.PersonVOV2;
import br.com.juliana.model.Person;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setFirstName(person.getFirstName());
        vo.setGender(person.getGender());
        vo.setLastName(person.getLastName());
        vo.setBirthDay(new Date());

        return vo;
    }

    public Person convertEntityVoToEntity(PersonVOV2 person){
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
        entity.setFirstName(person.getFirstName());
        entity.setGender(person.getGender());
        entity.setLastName(person.getLastName());
        //entity.setBirthDay(new Date());

        return entity;
    }

}
