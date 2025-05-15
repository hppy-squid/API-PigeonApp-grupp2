package PigeonApp.PigeonApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class IssueController {

    @Autowired
    private IssueService issueService;

    // skapa en issue
    @PostMapping("/newIssue/{projectId}")
    public Issue createIssue(@RequestBody Issue issue, @PathVariable String projectId) {
        return issueService.createIssue(issue, projectId);
    }

    // // uppdatera specifikt issue
    // @PatchMapping("/setEstimatedTime")
    // //
    // hämta alla inaktiva issues
    @GetMapping("/inactiveIssues")
    public List<Issue> getInactiveIssues() {
        return issueService.getInactiveIssues();
    }

    // // hämta alla aktiva issues
    @GetMapping("/activeIssues")
    public List<Issue> getActiveIssues() {
        return issueService.getActiveIssues();
    }

    // // hämta alla fädiga issues
    @GetMapping("/finishedIssues")
    public List<Issue> getFinishedIssues() {
        return issueService.getFinishedIssues();
    }
}
