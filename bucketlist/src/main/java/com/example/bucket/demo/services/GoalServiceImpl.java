package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Bucket;
import com.example.bucket.demo.models.Category;
import com.example.bucket.demo.models.Goal;
import com.example.bucket.demo.models.Person;
import com.example.bucket.demo.models.dtos.GoalSettings;
import com.example.bucket.demo.repos.GoalRepository;
import java.util.ArrayList;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalServiceImpl implements GoalService {

  private GoalRepository goalRepo;
  private PersonService personService;
  private BucketService bucketService;
  private CategoryService categoryService;

  @Autowired
  public GoalServiceImpl(GoalRepository goalRepo,
      PersonService personService, BucketService bucketService, CategoryService catService) {
    this.goalRepo = goalRepo;
    this.personService = personService;
    this.bucketService = bucketService;
    this.categoryService = catService;
  }

  @Override
  public List<Goal> findAllGoals(long personId) {
    Person owner = personService.findById(personId);
    List<Bucket> buckets = bucketService.findByOwner(owner);
    List<Goal> goals = getAllGoals(buckets);
    return goals;
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

  @Override
  public List<Goal> findGoalsInBucket(long personId, String bucketName) {
    Person owner = personService.findById(personId);
    Bucket searchedBucket = bucketService.findByOwnerAndName(owner,bucketName);
    List<Goal> goalsInBucket = getAllGoals(searchedBucket);
    return goalsInBucket;
  }

  @Override
  public void completeGoal(long goalid) throws NotFoundException {
    Goal toComplete = goalRepo.findById(goalid).orElse(null);
    if (toComplete != null){
      toComplete.setCompleted(true);
      goalRepo.save(toComplete);
    } else {
      throw new NotFoundException("Could not find a goal with this id");
    }
  }

  private Goal createNewGoal(long personId, GoalSettings goalSettings){
    Person owner = personService.findById(personId);
    Category category = categoryService.findByName(goalSettings.getCategoryName());
    Bucket toAddTo = bucketService.findByOwnerAndCategory(owner,category);
    Goal created = new Goal(goalSettings.getGoalName(), toAddTo, category, goalSettings.getStatus(), goalSettings.getLink());
    return created;
  }

  private List<Goal> getAllGoals(List<Bucket> buckets){
    List <Goal> allGoals = new ArrayList<>();
    for (int i = 0; i < buckets.size() ; i++) {
      List<Goal> goals = buckets.get(i).getGoals();
      for (int j = 0; j < goals.size() ; j++) {
        allGoals.add(goals.get(j));
      }
    }
    return allGoals;
  }

  private List<Goal> getAllGoals(Bucket bucket){
    List<Goal> goals = new ArrayList<>();
    for (Goal goal:bucket.getGoals()) {
      goals.add(goal);
    }
    return goals;
  }


}
