package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Person;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

  Person findById(long id);

}
