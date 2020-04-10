package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Bucket;
import org.springframework.stereotype.Service;

@Service
public interface BucketService {

  void save(Bucket bucket);

  Bucket findByName(String Name);

  Bucket findById(long id);

}
