package com.example.bucket.demo.controllers;

import com.example.bucket.demo.models.dtos.BucketSettings;
import com.example.bucket.demo.models.dtos.GoalSettings;
import com.example.bucket.demo.services.BucketService;
import javax.management.BadAttributeValueExpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BucketController {

  private BucketService bucketService;

  @Autowired
  public BucketController(BucketService bucketService) {
    this.bucketService = bucketService;
  }

  @PostMapping("{id}/bucket/add")
  public ResponseEntity<?> addNewBucket(
      @PathVariable(value = "id") long personId,
      @RequestBody BucketSettings bucketSettings) throws BadAttributeValueExpException {
    if (bucketService.validateNewBucket(personId, bucketSettings)) {
      bucketService.saveNewBucket(personId, bucketSettings);
      return new ResponseEntity(HttpStatus.CREATED);
    } else {
      throw new BadAttributeValueExpException("Could not create new bucket");
    }
  }
}
