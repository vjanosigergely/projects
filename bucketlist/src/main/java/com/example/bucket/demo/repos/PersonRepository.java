package com.example.bucket.demo.repos;

import com.example.bucket.demo.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
