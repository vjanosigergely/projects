package com.example.bucket.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  @ManyToOne
  private Bucket bucket;
  @ManyToOne
  private Category category;
  boolean completed = false;
  private String status;
  private String link;

  public Goal(String name, Bucket bucket, Category category){
    this.name = name;
    this.bucket=bucket;
    this.category = category;
  }

  public Goal(String name, Bucket bucket,String link,Category category){
    this(name,bucket,category);
    this.link=link;
  }

  public Goal(String name, Bucket bucket, Category category, String status, String link) {
    this.name = name;
    this.bucket = bucket;
    this.category = category;
    this.status = status;
    this.link = link;
  }
}
