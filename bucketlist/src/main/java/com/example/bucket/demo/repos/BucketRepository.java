package com.example.bucket.demo.repos;

import com.example.bucket.demo.models.Bucket;
import com.example.bucket.demo.models.Category;
import com.example.bucket.demo.models.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepository extends JpaRepository<Bucket,Long> {

  Bucket findByOwnerAndCategory(Person owner, Category category);

  List<Bucket> findByOwner(Person person);

}
