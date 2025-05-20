package PigeonApp.PigeonApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PigeonApp.PigeonApp.models.Member;
import PigeonApp.PigeonApp.services.ProjectService;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    private ProjectService projectService;

    // hämta alla medlemmar
    @GetMapping("/getAllMembers")
    public List<Member> getAllmembers() {
        return projectService.getAllMembers();
    }

    // hämta alla medlemmar i ett specifikt projekt
    @GetMapping("/getMembersByProjectId/{projectId}")
    public List<Member> getMembersByProjectId(@PathVariable String projectId) {
        return projectService.getMembersByProjectId(projectId);
    }

}
