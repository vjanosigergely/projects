package com.example.bucket.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  @ManyToOne
  private Category category;
  @ManyToOne
  private Person person;
  @OneToMany(mappedBy = "bucket")
  @JsonIgnore
  private List<Goal> goals;

  public Bucket(String name) {
    this.name = name;
  }

  public Bucket(String name, Category category, Person owner) {
    this.name = name;
    this.category = category;
    this.person = owner;
  }

  public void addGoal(Goal newGoal){
    newGoal.setBucket(this);
    goals.add(newGoal);
  }


}
