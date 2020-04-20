package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Bucket;
import com.example.bucket.demo.models.Category;
import com.example.bucket.demo.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

  private BucketService bucketService;
  private PersonService personService;
  private CategoryService categoryService;

  @Autowired
  public MainService(BucketService bucketService,
      PersonService personService, CategoryService categoryService) {
    this.bucketService = bucketService;
    this.personService = personService;
    this.categoryService = categoryService;
  }

  public void initialize() {
    Category category = new Category("Books");
    Person admin = new Person("admin","admin@admin.com","admin");
    Bucket books = new Bucket("Books to read",category,admin);
    categoryService.save(category);
    personService.save(admin);
    bucketService.save(books);
  }
}
