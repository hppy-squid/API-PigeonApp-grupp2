package PigeonApp.PigeonApp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import PigeonApp.PigeonApp.models.Member;

public interface MemberRepository extends MongoRepository<Member, String> {

}
