package PigeonApp.PigeonApp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import PigeonApp.PigeonApp.models.Project;

public interface ProjectRepository extends MongoRepository<Project, String> {

    List<Project> findByActiveProject(boolean activeProject);

}
