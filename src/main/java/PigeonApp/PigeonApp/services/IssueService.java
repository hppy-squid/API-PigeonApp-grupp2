package PigeonApp.PigeonApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PigeonApp.PigeonApp.models.EstimatedTime;
import PigeonApp.PigeonApp.models.Issue;
import PigeonApp.PigeonApp.models.IssueStatus;
import PigeonApp.PigeonApp.models.Project;
import PigeonApp.PigeonApp.repositories.EstimatedTimeRepository;
import PigeonApp.PigeonApp.repositories.IssueRepository;
import PigeonApp.PigeonApp.repositories.ProjectRepository;

@Service
public class IssueService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private EstimatedTimeRepository estimatedTimeRepository;
  

    // skapa en issue
    public Issue createIssue(Issue issue, String projectId) {
        
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Projektet finns inte"));
        issue.setProjectId(projectId);
       
        Issue savedIssue = issueRepository.save(issue);
      
        project.getIssues().add(savedIssue);
        projectRepository.save(project);

        return savedIssue;
    }

    // hämta alla inaktiva issues
    public List<Issue> getInactiveIssues(String projectId) {
    return issueRepository.findByProjectIdAndIssueStatus(projectId, IssueStatus.INACTIVE);
    }
   
    // hämta alla aktiva issues
    public List<Issue> getActiveIssues(String projectId) {
        return issueRepository.findByProjectIdAndIssueStatus(projectId, IssueStatus.ACTIVE);
    }

    // hämta alla fädiga issues
    public List<Issue> getFinishedIssues(String projectId) {
        return issueRepository.findByProjectIdAndIssueStatus(projectId, IssueStatus.DONE);
    }

    
    // Uppdatera issues med estimerad tid
    public List<EstimatedTime> updateEstTime(Issue issue, String issueId) {

        Issue existingIssue = issueRepository.findById(issueId)
            .orElseThrow(() -> new RuntimeException("Issuet finns inte"));

        List<EstimatedTime> updatedEstimates = new ArrayList<>();

        List<EstimatedTime> incomingEstimates = issue.getEstimatedTimes();

        if (incomingEstimates != null && !incomingEstimates.isEmpty()) {
            for (EstimatedTime estimate : incomingEstimates) {
                EstimatedTime estimatedTime = new EstimatedTime();
                estimatedTime.setIssueId(issueId);
                estimatedTime.setTimeEstimate(estimate.getTimeEstimate());

                estimatedTimeRepository.save(estimatedTime);
                updatedEstimates.add(estimatedTime);
            }

        existingIssue.setEstimatedTimes(updatedEstimates);

        // Uppdatera medelvärdet av uppskattade tider
        int averageTime = updatedEstimates.stream()
                .mapToInt(EstimatedTime::getTimeEstimate)
                .filter(time -> time > 0)  
                .sum() / Math.max(updatedEstimates.size(), 1);  

        existingIssue.setAvarageEstTime(averageTime);
        issueRepository.save(existingIssue);
    } else {
        throw new RuntimeException("Ingen uppskattad tid angiven");
    }

    return updatedEstimates;
    }

    // uppdatera issues med den faktiska tiden
    public Issue actualTime(Issue issue, String issueId) {

     Issue existingIssue = issueRepository.findById(issueId)
            .orElseThrow(() -> new RuntimeException("Issuet finns inte"));

    existingIssue.setActualTime(issue.getActualTime());

    issueRepository.save(existingIssue);

            
    return existingIssue;
   
    }

    // hämta specifika issues 
    public Issue getIssueById(String issueId) {

        Issue getIssueById = issueRepository.findById(issueId).orElse(null);
        
    return getIssueById;
   
    }

}
