package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Goal;
import com.example.bucket.demo.models.dtos.GoalSettings;
import java.util.List;
import javassist.NotFoundException;

public interface GoalService {

  List<Goal> findAllGoals(long personId);

  Goal findById(long id);

  void saveNewGoal(long personId, GoalSettings goalSettings);

  List<Goal> findGoalsInBucket(long personId, String bucketName);

  void completeGoal(long goalid) throws NotFoundException;
}
