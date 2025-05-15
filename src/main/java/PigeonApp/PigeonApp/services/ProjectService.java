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

    // Hämta alla aktiva projekt
    public List<Project> getAllActiveProjects() {
        List<Project> allActiveProjects = projectRepository.findByActiveProject(true);
        System.out.println("Active Projects: " + allActiveProjects);
        return allActiveProjects;

    }

    // Hämta alla avslutade projekt
    public List<Project> getAllFinishedProjects() {

        List<Project> allFinishedProjects = projectRepository.findByActiveProject(false);
        System.out.println("Active Projects: " + allFinishedProjects);
        return allFinishedProjects;

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
