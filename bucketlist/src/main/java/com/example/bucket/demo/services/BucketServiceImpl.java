package com.example.bucket.demo.services;

import com.example.bucket.demo.models.Bucket;
import com.example.bucket.demo.models.Category;
import com.example.bucket.demo.models.Person;
import com.example.bucket.demo.models.dtos.BucketSettings;
import com.example.bucket.demo.repos.BucketRepository;
import java.util.List;
import javax.management.BadAttributeValueExpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BucketServiceImpl implements BucketService {

  private BucketRepository bucketRepo;
  private PersonService personService;
  private CategoryService categoryService;

  @Autowired
  public BucketServiceImpl(BucketRepository bucketRepo, PersonService personService,
      CategoryService categoryService) {
    this.bucketRepo = bucketRepo;
    this.personService = personService;
    this.categoryService = categoryService;
  }

  @Override
  public void save(Bucket bucket) {
    bucketRepo.save(bucket);
  }

  @Override
  public Bucket findByOwnerAndCategory(Person owner, Category category) {
    return bucketRepo.findByPersonAndCategory(owner, category);
  }

  @Override
  public List<Bucket> findByOwner(Person person) {
    return bucketRepo.findByPerson(person);
  }

  @Override
  public Bucket findById(long id) {
    return null;
  }

  @Override
  public Bucket findByOwnerAndName(Person person, String bucketName) {
    return bucketRepo.findByPersonAndName(person, bucketName);
  }

  @Override
  public void saveNewBucket(Long personId, BucketSettings bucketSettings)
      throws BadAttributeValueExpException {
    if (validateNewBucket(personId, bucketSettings)) {
      Bucket toSave = createNewBucket(personId, bucketSettings);
      bucketRepo.save(toSave);
    } else {
      throw new BadAttributeValueExpException("Could not create bucket");
    }
  }

  @Override
  public boolean validateNewBucket(Long personId, BucketSettings bucketSettings) {
    if (personId == null || checkIfEmpty(bucketSettings)) {
      return false;
    } else {
      Person owner = personService.findById(personId);
      Category category = categoryService.findByName(bucketSettings.getCategoryName());
      List<Bucket> buckets = bucketRepo.findByPerson(owner);
      for (Bucket bucket : buckets) {
        if (bucket.getName().toLowerCase().equals(bucketSettings.getBucketName().toLowerCase())) {
          return false;
        }
        if (bucket.getCategory() == category) {
          return false;
        }
      }
      return true;
    }
  }

  private Bucket createNewBucket(long personId, BucketSettings bucketSettings) {
    Person owner = personService.findById(personId);
    Category category = categoryService.findByName(bucketSettings.getCategoryName());
    Bucket newBucket = new Bucket(bucketSettings.getBucketName(), category, owner);
    return newBucket;
  }

  private boolean checkIfEmpty(BucketSettings bucketSettings) {
    if (bucketSettings.getBucketName() == null
        || bucketSettings.getBucketName().equals("")
        || bucketSettings.getCategoryName() == null
        || bucketSettings.getCategoryName().equals("")){
      return true;
    } else {
      return false;
    }
  }
}
