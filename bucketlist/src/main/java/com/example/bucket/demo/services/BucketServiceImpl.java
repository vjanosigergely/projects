package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Bucket;
import com.example.bucket.demo.repos.BucketRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BucketServiceImpl implements BucketService {

  private BucketRepository bucketRepo;

  @Autowired
  public BucketServiceImpl(BucketRepository bucketRepo) {
    this.bucketRepo = bucketRepo;
  }

  @Override
  public Bucket findByName(String name) {
    return bucketRepo.findByName(name);
  }

  @Override
  public Bucket findById(long id) {
    return null;
  }
}
