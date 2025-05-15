package PigeonApp.PigeonApp.models;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
    @Id
    private String issueId;
    private String projectId;
    private String issueTitle;
    private String issueDescription;
    private int avarageEstTime; // medelvärde av allas estimation
    private int actualTime;
    private IssueStatus issueStatus; // skiftar statusläge ACTIVE, INACTIVE & DONE
    private List<Member> members;
}
