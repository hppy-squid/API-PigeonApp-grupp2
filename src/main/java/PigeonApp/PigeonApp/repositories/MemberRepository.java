package PigeonApp.PigeonApp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import PigeonApp.PigeonApp.models.Member;
import java.util.List;


public interface MemberRepository extends MongoRepository<Member, String> {
    List<Member> findByProjectId(String projectId);

}
