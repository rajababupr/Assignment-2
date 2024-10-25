package weather.service;

import weather.model.Alert;
import weather.model.WeatherData;
import weather.repository.AlertRepository;
import weather.repository.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertService {
    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @Autowired
    private AlertRepository alertRepository;

    public void checkForAlerts(String city) {
        List<WeatherData> recentData = weatherDataRepository.findByCityOrderByTimestampDesc(city);

        if (recentData.size() >= 2) {
            double lastTemp = recentData.get(0).getTemp();
            double secondLastTemp = recentData.get(1).getTemp();

            if (lastTemp > 35.0 && secondLastTemp > 35.0) {
                Alert alert = new Alert();
                alert.setCity(city);
                alert.setAlertMessage("Temperature exceeded 35°C for two consecutive updates");
                alert.setTimestamp(LocalDateTime.now());

                alertRepository.save(alert);
            }
        }
    }

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }
}
