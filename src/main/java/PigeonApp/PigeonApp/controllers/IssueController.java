package PigeonApp.PigeonApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/newIssue")
    public Issue createIssue() {
        return null;
    }    // hämta alla inaktiva issues
    @GetMapping("/inactiveIssues")
    // hämta alla aktiva issues
    @GetMapping("/activeIssues")
    // hämta alla fädiga issues
    @GetMapping("/finishedIssues")
}
