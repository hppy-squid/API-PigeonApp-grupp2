package PigeonApp.PigeonApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PigeonApp.PigeonApp.models.Project;
import PigeonApp.PigeonApp.services.ProjectService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // hämta alla aktiva projekt
    @GetMapping("/activeProjects")
    public List<Project> getAllActiveProjects() {
        System.out.println("Getting all active projects");
        return projectService.getAllActiveProjects();
    }

    // hämta specifikt projekt
    @GetMapping("/{projectId}")
    public Project getProjectById(@PathVariable String projectId) {
        return projectService.getProjectById(projectId);
    }

    // hämta alla avslutade projekt
    @GetMapping("/finishedProjects")
    public List<Project> getAllFinishedProjects() {
        System.out.println("Getting all finished projects");
        return projectService.getAllFinishedProjects();
    }

    // skapa nytt projekt
    @PostMapping("/newProject")
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    // Hämtar alla projekt
    @GetMapping("/allProjects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    //
    @PatchMapping("/updateProjectStatus/{projectId}")
    public Project updateProjectToFinshed(@PathVariable String projectId) {
        return projectService.updateProjectToFinshed(projectId);
    }

}
