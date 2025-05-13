package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Member;

public interface MemberRepository extends MongoRepository<Member, String> {

}
