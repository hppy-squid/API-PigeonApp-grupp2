package PigeonApp.PigeonApp.models;

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
@Document(collection = "estimatedTimes")
public class EstimatedTime {

    @Id
    private String estimatedTimeId;
    private String issueId; //Kopplar till issue
    private String memberId;
    private int timeEstimate;
    
}
