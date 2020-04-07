package com.example.bucket.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Goal {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  @ManyToOne
  @JsonIgnore
  private Category category;
  boolean completed;
  private String status;
  private String link;

  public Goal(String name, Category category){
    this.name = name;
    this.category=category;
  }

  public Goal(String name, Category category,String link){
    this(name,category);
    this.link=link;

  }



}
