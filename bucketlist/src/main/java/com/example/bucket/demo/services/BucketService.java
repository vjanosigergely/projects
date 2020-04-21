package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Bucket;
import com.example.bucket.demo.models.Category;
import com.example.bucket.demo.models.Person;
import com.example.bucket.demo.models.dtos.BucketSettings;
import java.util.List;
import javax.management.BadAttributeValueExpException;


public interface BucketService {

  void save(Bucket bucket);

  Bucket findByOwnerAndCategory(Person owner, Category category);

  List<Bucket> findByOwner(Person person);

  Bucket findById(long id);


  Bucket findByOwnerAndName(Person person, String bucketName);

  void saveNewBucket(Long personId, BucketSettings bucketSettings) throws BadAttributeValueExpException;

  boolean validateNewBucket(Long personId, BucketSettings bucketSettings) throws BadAttributeValueExpException;
}
