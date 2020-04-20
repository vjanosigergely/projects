package com.example.bucket.demo.repos;

import com.example.bucket.demo.models.Bucket;
import com.example.bucket.demo.models.Goal;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends CrudRepository<Goal,Long> {
List<Goal> findAllByBucket(Bucket bucket);
}
