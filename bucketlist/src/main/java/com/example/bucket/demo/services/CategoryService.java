package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

  Category findByName (String name);

  void save(Category category);



}
