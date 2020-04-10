package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Bucket;
import com.example.bucket.demo.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

  private BucketService bucketService;
  private PersonService personService;

  @Autowired
  public MainService(BucketService bucketService,
      PersonService personService) {
    this.bucketService = bucketService;
    this.personService = personService;
  }

  public void initialize() {
    Person admin = new Person("admin","admin@admin.com","minda");
    Bucket books = new Bucket("Books to Read");
    admin.addBucket(books);
    bucketService.save(books);
    personService.save(admin);

  }
}
