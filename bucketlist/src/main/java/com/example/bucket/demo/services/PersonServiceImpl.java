package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Person;
import com.example.bucket.demo.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl implements PersonService {

  private PersonRepository personRepository;

  @Autowired
  public PersonServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public void save(Person person) {
    personRepository.save(person);
  }

  @Override
  public Person findById(long id) {
    return personRepository.findById(id).orElse(null);
  }
}
