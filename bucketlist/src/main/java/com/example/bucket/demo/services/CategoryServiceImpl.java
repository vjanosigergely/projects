package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Category;
import com.example.bucket.demo.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {

  private CategoryRepository catRepo;

  @Autowired
  public CategoryServiceImpl(CategoryRepository catRepo) {
    this.catRepo = catRepo;
  }

  @Override
  public Category findByName(String name) {
    return catRepo.findByName(name);
  }

  @Override
  public void save(Category category) {
    catRepo.save(category);

  }
}
