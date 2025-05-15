package PigeonApp.PigeonApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import PigeonApp.PigeonApp.models.Project;
import PigeonApp.PigeonApp.services.ProjectService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/activeProjects")
    public List<Project> getAllActiveProjects(Project project) {
        System.out.println("Getting all active projects" + project);
        return projectService.getAllActiveProjects(project);
    }

    @GetMapping("/finishedProjects")
    public List<Project> getAllFinishedProjects(Project project) {
        System.out.println("Getting all finished projects" + project);
        return projectService.getAllFinishedProjects(project);
    }

    @PostMapping("/newProject")
    public Project createProject(@RequestBody Project project) {

        return projectService.createProject(project);
    }

}
