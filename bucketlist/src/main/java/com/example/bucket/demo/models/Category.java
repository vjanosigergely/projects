package com.example.bucket.demo.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
  private long id;
  private String name;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.EAGER)
  private List<Bucket> buckets;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.EAGER)
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
