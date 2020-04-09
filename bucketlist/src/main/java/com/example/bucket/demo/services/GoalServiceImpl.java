package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Bucket;
import com.example.bucket.demo.models.Goal;
import com.example.bucket.demo.models.Person;
import com.example.bucket.demo.models.dtos.GoalSettings;
import com.example.bucket.demo.repos.GoalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class GoalServiceImpl implements GoalService {

  private GoalRepository goalRepo;
  private PersonService personService;
  private BucketService bucketService;

  @Autowired
  public GoalServiceImpl(GoalRepository goalRepo,
      PersonService personService, BucketService bucketService) {
    this.goalRepo = goalRepo;
    this.personService = personService;
    this.bucketService = bucketService;
  }

  @Override
  public List<Goal> findAllGoals(long personId) {
    Person owner = personService.findById(personId);
    return goalRepo.findAllByOwner(owner);
  }

  @Override
  public Goal findById(long id) {
    return goalRepo.findById(id).orElse(null);
  }

  @Override
  public void saveNewGoal(long personId, GoalSettings goalSettings) {
    Goal toSave = this.createNewGoal(personId,goalSettings);
    goalRepo.save(toSave);
  }

  private Goal createNewGoal(long personId, GoalSettings goalSettings){
    Bucket toAddTo = bucketService.findByName(goalSettings.getBucketName());
    Person owner = personService.findById(personId);
    Goal created = new Goal(goalSettings.getGoalName(), toAddTo,goalSettings.getStatus(),owner);
    return created;
  }


}
