package models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "estimatedTimes")
public class EstimatedTime {
    private String id; //Hanterar member id
    private double timeEstimate;
    
}
