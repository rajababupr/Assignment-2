package weather.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather_data")
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String city;
    private double temp;
    private double feelsLike;
    private String mainCondition;
    private LocalDateTime timestamp;
    
    // Getters and Setters
}
