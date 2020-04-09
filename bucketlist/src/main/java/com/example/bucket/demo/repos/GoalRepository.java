package com.example.bucket.demo.repos;

import com.example.bucket.demo.models.Goal;
import com.example.bucket.demo.models.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal,Long> {
List<Goal> findAllByOwner(Person person);
}
