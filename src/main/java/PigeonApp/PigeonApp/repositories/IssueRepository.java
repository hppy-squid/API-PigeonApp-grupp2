package PigeonApp.PigeonApp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import PigeonApp.PigeonApp.models.Issue;
import PigeonApp.PigeonApp.models.IssueStatus;

public interface IssueRepository extends MongoRepository<Issue, String> {
    List<Issue> findByIssueStatus(IssueStatus issueStatus);
    List<Issue> findByProjectIdAndIssueStatus(String projectId, IssueStatus issueStatus);
}
