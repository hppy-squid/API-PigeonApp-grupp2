package PigeonApp.PigeonApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PigeonApp.PigeonApp.models.Issue;
import PigeonApp.PigeonApp.repositories.IssueRepository;
import PigeonApp.PigeonApp.repositories.MemberRepository;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private MemberRepository memberRepository;

    // skapa en issue
    public Issue createIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    // uppdatera en issue "by ID"

    // hämta alla inaktiva issues

    // hämta alla aktiva issues

    // hämta alla fädiga issues
}
