package weather.service;

import weather.model.WeatherData;
import weather.repository.WeatherDataRepository;
import weather.util.WeatherUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService {
    @Autowired
    private WeatherDataRepository weatherDataRepository;

    private final String apiKey = "YOUR_API_KEY";
    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 300000) // Every 5 minutes
    public void fetchWeatherData() {
        String[] cities = {"Delhi", "Mumbai", "New York"};
        for (String city : cities) {
            String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", city, apiKey);
            String response = restTemplate.getForObject(url, String.class);

            WeatherData data = WeatherUtils.parseWeatherData(response);
            weatherDataRepository.save(data);
        }
    }

    // Add other methods for processing data, if needed
}
