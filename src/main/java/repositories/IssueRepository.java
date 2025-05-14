package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Issue;

public interface IssueRepository extends MongoRepository<Issue, String> {

}
