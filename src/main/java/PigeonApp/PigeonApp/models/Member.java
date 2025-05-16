package PigeonApp.PigeonApp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "members")
public class Member {
    @Id
    private String memberId;
    private String projectId; //Kopplar till projekt
    private String memberName;
    private int timeEstimate;

}
