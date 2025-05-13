package models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "issues")
public class Issue {
    @Id
    private String issueId;
    private String issueTitle;
    private String issueDescription;
    private double avarageEstTime; // medelvärde av allas estimation
    private double actualTime;
    private boolean activeIssue;
    private List<EstimatedTime> estimatedTimeList = new ArrayList<>();
}
