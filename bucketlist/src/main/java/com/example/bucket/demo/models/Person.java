package com.example.bucket.demo.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Person {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String username;
  private String email;
  private String password;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "bucket", fetch = FetchType.EAGER)
  private List<Bucket> buckets;

  public Person(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public void addBucket(Bucket bucketToAdd){
    buckets.add(bucketToAdd);
  }
}
