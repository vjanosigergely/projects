package com.example.bucket.demo.controllers;

import com.example.bucket.demo.models.Goal;
import com.example.bucket.demo.models.dtos.GoalSettings;
import com.example.bucket.demo.services.GoalService;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  private GoalService goalService;

  @Autowired
  public MainController(GoalService goalService) {
    this.goalService = goalService;
  }

  //{userid}/goal/list - list all goals
  @GetMapping("{id}/goal/list")
  public ResponseEntity<?> listAllGoals(@PathVariable(value = "id") long personId) throws NotFoundException{
    List<Goal> goals = goalService.findAllGoals(personId);
    if (!goals.isEmpty()){
      return ResponseEntity.status(HttpStatus.OK).body(goals);
    } else {
      throw new NotFoundException("You don't have any goals yet");
    }
  }

  //{userid}/goal/add - add new goal
  @GetMapping("{id}/goal/add")
  public ResponseEntity<?> addNewGoal(@PathVariable(value = "id") long personId, @RequestBody GoalSettings goalSettings){
    goalService.saveNewGoal(personId,goalSettings);
    return new ResponseEntity(HttpStatus.CREATED);
  }

  //{userid}/{bucketid}/list - list goals in a specific bucket



  //{userid}/goal/add - add new goal
  //{userid}/goal/{goalid}/complete


}
