package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import models.Member;
import models.Project;
import repositories.ProjectRepository;

public class ProjectService {


    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllActiveProjects(Project project) {
        if (project.isActiveProject()) {
             projectRepository.findAll();
            List<Project> allActiveProjects = projectRepository.findAll();

            System.out.println("Active Projects: " + allActiveProjects );

        return allActiveProjects;
         } else {
            return null;
        }
    }

    public List<Project> getAllFinishedProjects(Project project) {
        if (!project.isActiveProject()){
            projectRepository.findAll();
            List<Project> allFinishedProjects = projectRepository.findAll();

            System.out.println("Active Projects: " + allFinishedProjects );

            return allFinishedProjects;
        } else {
            return null;
        }
    }

    public Project createProject(Project project, List<Member> members, String title ) {

        Project newProject = new Project();
        project.setTitle(title);
        project.setMembers(members);
        project.setActiveProject(true);
        project.setIssues(new ArrayList<>());

        projectRepository.save(newProject);

        System.out.println("Project created"+ newProject);

        return newProject;
       
    }
    
}
