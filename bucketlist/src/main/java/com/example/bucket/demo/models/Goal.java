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
  private Bucket bucket;
  private Person owner;
  boolean completed = false;
  private String status;
  private String link;

  public Goal(String name, Bucket bucket, Person owner){
    this.name = name;
    this.bucket=bucket;
    this.owner = owner;
  }

  public Goal(String name, Bucket bucket,String link,Person owner){
    this(name,bucket,owner);
    this.link=link;
  }



}
