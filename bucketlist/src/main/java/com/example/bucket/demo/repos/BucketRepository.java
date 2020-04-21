package com.example.bucket.demo.repos;

import com.example.bucket.demo.models.Bucket;
import com.example.bucket.demo.models.Category;
import com.example.bucket.demo.models.Person;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepository extends CrudRepository<Bucket,Long> {

  Bucket findByPersonAndCategory (Person owner, Category category);

  List<Bucket> findByPerson(Person person);

  Bucket findByPersonAndName(Person owner, String name);

}
