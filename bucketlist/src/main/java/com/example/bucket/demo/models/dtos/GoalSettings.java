package com.example.bucket.demo.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GoalSettings {

  private String goalName;
  private String categoryName;
  private String status;
  private String link;


}
