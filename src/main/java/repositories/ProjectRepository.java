package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Project;

public interface ProjectRepository extends MongoRepository<Project, String> {

}
