package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Bucket;
import com.example.bucket.demo.models.Category;
import com.example.bucket.demo.models.Person;
import com.example.bucket.demo.repos.BucketRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BucketServiceImpl implements BucketService {

  private BucketRepository bucketRepo;

  @Autowired
  public BucketServiceImpl(BucketRepository bucketRepo) {
    this.bucketRepo = bucketRepo;
  }

  @Override
  public void save(Bucket bucket) {
    bucketRepo.save(bucket);
  }

  @Override
  public Bucket findByOwnerAndCategory(Person owner, Category category) {
    return bucketRepo.findByPersonAndCategory(owner,category);
  }

  @Override
  public List<Bucket> findByOwner(Person person) {
    return bucketRepo.findByPerson(person);
  }

  @Override
  public Bucket findById(long id) {
    return null;
  }
}
