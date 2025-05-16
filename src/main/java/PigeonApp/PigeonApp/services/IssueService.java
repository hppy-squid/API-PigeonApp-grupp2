package PigeonApp.PigeonApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PigeonApp.PigeonApp.models.Issue;
import PigeonApp.PigeonApp.models.IssueStatus;
import PigeonApp.PigeonApp.models.Project;
import PigeonApp.PigeonApp.repositories.EstimatedTimeRepository;
import PigeonApp.PigeonApp.repositories.IssueRepository;
import PigeonApp.PigeonApp.repositories.MemberRepository;
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
}
