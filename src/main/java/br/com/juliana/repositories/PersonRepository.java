package br.com.juliana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.juliana.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{}
