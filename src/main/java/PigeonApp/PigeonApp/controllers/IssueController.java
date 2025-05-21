package PigeonApp.PigeonApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PigeonApp.PigeonApp.models.Issue;
import PigeonApp.PigeonApp.services.IssueService;

@RestController
@RequestMapping("/api/issues")
@CrossOrigin(origins = "*")
public class IssueController {

    @Autowired
    private IssueService issueService;

    // skapa nytt issue till projekt
    @PostMapping("/newIssue/{projectId}")
    public Issue createIssue(@RequestBody Issue issue, @PathVariable String projectId) {
        return issueService.createIssue(issue, projectId);
    }

    // hämta specifikt issue
    @GetMapping("/{issueId}")
        public Issue getIssueById(@PathVariable String issueId) {
            return issueService.getIssueById(issueId);
        }

    // hämta alla aktiva issues för ett projekt
    @GetMapping("/activeIssues/{projectId}")
    public List<Issue> getActiveIssues(@PathVariable String projectId) {
        return issueService.getActiveIssues(projectId);
    }

    // hämta alla fädiga issues för ett projekt
    @GetMapping("/finishedIssues/{projectId}")
    public List<Issue> getFinishedIssues(@PathVariable String projectId) {
        return issueService.getFinishedIssues(projectId);
    }

     // hämta alla inaktiva issues för ett projekt
    @GetMapping("/inactiveIssues/{projectId}")
    public List<Issue> getInactiveIssues(@PathVariable String projectId) {
        return issueService.getInactiveIssues(projectId);
    }
}
