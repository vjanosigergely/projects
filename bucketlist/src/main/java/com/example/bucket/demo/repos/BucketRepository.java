package com.example.bucket.demo.repos;

import com.example.bucket.demo.models.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepository extends JpaRepository<Bucket,Long> {

  Bucket findByName(String name);

}
