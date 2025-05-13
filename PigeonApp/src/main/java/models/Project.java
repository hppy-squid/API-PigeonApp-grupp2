package models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "projects")
public class Project {
    @Id
    private String projectId;
    private String title;
    private List<Member> members = new ArrayList<>();
    private List<Issue> issues = new ArrayList<>();
    
}
