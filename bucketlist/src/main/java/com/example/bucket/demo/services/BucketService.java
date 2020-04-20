package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Bucket;
import com.example.bucket.demo.models.Category;
import com.example.bucket.demo.models.Person;
import java.util.List;


public interface BucketService {

  void save(Bucket bucket);

  Bucket findByOwnerAndCategory(Person owner, Category category);

  List<Bucket> findByOwner(Person person);

  Bucket findById(long id);


}
