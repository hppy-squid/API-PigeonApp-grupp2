package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Member;
import models.Project;
import services.ProjectService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/activeProjects")
    public List<Project> getAllActiveProjects(@RequestBody Project project) {
        System.out.println("Getting all active projects" + project);
        return projectService.getAllActiveProjects(project);
    }

    @GetMapping("/finishedProjects")
    public List<Project> getAllFinishedProjects(@RequestBody Project project) {
        System.out.println("Getting all finished projects" + project);
        return projectService.getAllFinishedProjects(project);
    }

    @PostMapping("/newProject")
    public Project createProject (@RequestBody Project project, List<Member> members, String title) {
        System.out.println("Creating new project" + project);
        return projectService.createProject(project, members, title);
       
    }
    
    
}
