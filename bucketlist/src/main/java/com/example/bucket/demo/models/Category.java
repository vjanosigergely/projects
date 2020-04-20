package com.example.bucket.demo.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  @OneToMany(mappedBy = "category")
  private List<Bucket> buckets;
  @OneToMany(mappedBy = "category")
  private List<Goal> goals;

  public Category(String name) {
    this.name = name;
  }

  public void addBucket(Bucket bucket){
    buckets.add(bucket);
  }

  public void addGoal(Goal goal){
    goals.add(goal);
  }

}
