package weather.controller;

import weather.model.Alert;
import weather.service.AlertService;
import weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private AlertService alertService;

    @GetMapping("/weather-summary")
    public String getWeatherSummary(Model model) {
        // Add logic to fetch and process weather summary data from WeatherService
        model.addAttribute("summary", weatherService.getWeatherSummary());
        return "weather_summary";
    }

    @GetMapping("/alerts")
    public String getAlerts(Model model) {
        List<Alert> alerts = alertService.getAllAlerts();
        model.addAttribute("alerts", alerts);
        return "alerts";
    }
}
