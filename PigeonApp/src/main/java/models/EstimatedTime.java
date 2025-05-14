package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstimatedTime {
    private String id; //Hanterar member id
    private double timeEstimate;
    
}
