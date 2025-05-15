package PigeonApp.PigeonApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PigeonApp.PigeonApp.models.Member;
import PigeonApp.PigeonApp.models.Project;
import PigeonApp.PigeonApp.repositories.MemberRepository;
import PigeonApp.PigeonApp.repositories.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<Project> getAllActiveProjects(Project project) {
        if (project.isActiveProject()) {
            projectRepository.findAll();
            List<Project> allActiveProjects = projectRepository.findAll();

            System.out.println("Active Projects: " + allActiveProjects);

            return allActiveProjects;
        } else {
            return null;
        }
    }

    public List<Project> getAllFinishedProjects(Project project) {
        if (!project.isActiveProject()) {
            projectRepository.findAll();
            List<Project> allFinishedProjects = projectRepository.findAll();

            System.out.println("Active Projects: " + allFinishedProjects);

            return allFinishedProjects;
        } else {
            return null;
        }
    }

    public Project createProject(Project project) {

        // sparar medlemmarna i databasen
        List<Member> saveMembers = memberRepository.saveAll(project.getMembers());
        project.setMembers(saveMembers);

        Project savProject = projectRepository.save(project);

        System.out.println("Project created" + project);

        return savProject;

    }

}
