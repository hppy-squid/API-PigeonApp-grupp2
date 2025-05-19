package PigeonApp.PigeonApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PigeonApp.PigeonApp.models.EstimatedTime;
import PigeonApp.PigeonApp.models.Issue;
import PigeonApp.PigeonApp.services.IssueService;

@RestController
@RequestMapping("/api/estTime")
public class EstimatedTimeController {

    @Autowired
    private IssueService issueService;

    @GetMapping("/getEstTime")
    public List<EstimatedTime> getEstTime(){
        return null;
    }

    @PatchMapping("/updateEstTime/{issueId}")
    public List<EstimatedTime> updateEstTime(@RequestBody Issue issue, @PathVariable String issueId){
        return issueService.updateEstTime(issue, issueId);
    }
    
}
