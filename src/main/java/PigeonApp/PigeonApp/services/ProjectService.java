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


        Project savProject = projectRepository.save(project);
        List<Member> members = project.getMembers();

        for(Member m : members){
            m.setProjectId(project.getProjectId());
        }
        // sparar medlemmarna i databasen
        List<Member> saveMembers = memberRepository.saveAll(project.getMembers());
        project.setMembers(saveMembers);

        System.out.println("Project created" + project);

        return savProject;

    }

    public List<Member> getAllMembers() {
        List<Member> getAllMembers = memberRepository.findAll();
        return getAllMembers;
    }

    public List<Member> getMembersByProjectId(String projectId){
        List<Member> getMembersByProjectId = memberRepository.findByProjectId(projectId);
        return getMembersByProjectId;
    }

}
