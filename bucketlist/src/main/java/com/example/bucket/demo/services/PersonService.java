package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Person;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

  void save (Person person);

  Person findById(long id);


}
