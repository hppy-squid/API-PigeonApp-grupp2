package PigeonApp.PigeonApp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import PigeonApp.PigeonApp.models.Issue;

public interface IssueRepository extends MongoRepository<Issue, String> {

}
