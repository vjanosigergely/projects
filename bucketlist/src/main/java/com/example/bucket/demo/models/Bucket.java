package com.example.bucket.demo.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
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
public class Bucket {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  @ManyToOne
  private Category category;
  @ManyToOne
  private Person owner;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bucket", fetch = FetchType.EAGER)
  private List<Goal> goals;

  public Bucket(String name) {
    this.name = name;
  }

  public Bucket(String name, Category category, Person owner) {
    this.name = name;
    this.category = category;
    this.owner = owner;
  }

  public void addGoal(Goal newGoal){
    newGoal.setBucket(this);
    goals.add(newGoal);
  }


}
