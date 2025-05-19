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
        // Kontrollera att projektet finns
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Projektet finns inte"));
        issue.setProjectId(projectId);
        // Spara issue först (så den får ett ID)
        Issue savedIssue = issueRepository.save(issue);
        // Lägg till issue i projektets lista och spara projektet
        project.getIssues().add(savedIssue);
        projectRepository.save(project);
        return savedIssue;
    }

    // uppdatera en issue "by ID"
    // hämta alla inaktiva issues
    public List<Issue> getInactiveIssues() {
        return issueRepository.findByIssueStatus(IssueStatus.INACTIVE);
    }

    // hämta alla aktiva issues
    public List<Issue> getActiveIssues() {
        return issueRepository.findByIssueStatus(IssueStatus.ACTIVE);
    }

    // hämta alla fädiga issues
    public List<Issue> getFinishedIssues() {
        return issueRepository.findByIssueStatus(IssueStatus.DONE);
    }

    public List<EstimatedTime> updateEstTime(Issue issue, String issueId) {
        // Hämta befintligt issue
        Issue existingIssue = issueRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issuet finns inte"));
        List<EstimatedTime> updatedEstimates = new ArrayList<>();
        // Hämta inkommande estimerade tider från RequestBody
        List<EstimatedTime> incomingEstimates = issue.getEstimatedTimes();
        if (incomingEstimates != null && !incomingEstimates.isEmpty()) {
            for (EstimatedTime estimate : incomingEstimates) {
                // Skapa en ny EstimatedTime-objekt och sätt värdena
                EstimatedTime estimatedTime = new EstimatedTime();
                estimatedTime.setIssueId(issueId);
                estimatedTime.setTimeEstimate(estimate.getTimeEstimate());
                // Spara till databasen
                estimatedTimeRepository.save(estimatedTime);
                updatedEstimates.add(estimatedTime);
            }
            // Lägg till de uppdaterade estimerade tiderna i issuelistan
            existingIssue.setEstimatedTimes(updatedEstimates);
            // Uppdatera medelvärdet av uppskattade tider
            int averageTime = updatedEstimates.stream()
                    .mapToInt(EstimatedTime::getTimeEstimate)
                    .filter(time -> time > 0) // Filtrera bort 0-värden
                    .sum() / Math.max(updatedEstimates.size(), 1); // Undvik division med 0
            existingIssue.setAvarageEstTime(averageTime);
            issueRepository.save(existingIssue);
        } else {
            throw new RuntimeException("Ingen uppskattad tid angiven");
        }
        return updatedEstimates;
    }

    public Issue actualTime(Issue issue, String issueId) {
        Issue existingIssue = issueRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issuet finns inte"));
        existingIssue.setActualTime(issue.getActualTime());
        issueRepository.save(existingIssue);

        return existingIssue;

    }

    public Issue getIssueById(String issueId) {
        Issue getIssueById = issueRepository.findById(issueId).orElse(null);
        return getIssueById;

    }

}
