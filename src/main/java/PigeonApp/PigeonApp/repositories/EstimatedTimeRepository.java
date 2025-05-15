package PigeonApp.PigeonApp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import PigeonApp.PigeonApp.models.EstimatedTime;

public interface EstimatedTimeRepository extends MongoRepository<EstimatedTime, String> {

}
