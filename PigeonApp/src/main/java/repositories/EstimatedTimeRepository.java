package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.EstimatedTime;

public interface EstimatedTimeRepository extends MongoRepository<EstimatedTime, String> {

}
