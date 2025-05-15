package PigeonApp.PigeonApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PigeonApp.PigeonApp.repositories.IssueRepository;
import PigeonApp.PigeonApp.repositories.MemberRepository;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private MemberRepository memberRepository;

    // skapa en issue

    // hämta alla inaktiva issues

    // hämta alla aktiva issues

    // hämta alla fädiga issues
}
