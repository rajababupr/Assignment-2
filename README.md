# Assignment-2

Real-Time Weather Monitoring System in Java. The solution includes key components like fetching data, processing data, triggering alerts, database handling, and visualization.
1.Main Application initializes the Spring Boot application with WeatherApplication.java.
2.WeatherService is responsible for fetching weather data periodically from OpenWeatherMap using the @Scheduled annotation.
3.WeatherDataRepository persists the fetched data into the weather_data table in MySQL.
4.AlertService checks the stored weather data in the weather_data table to determine if any alerts should be triggered.
5.AlertRepository persists any triggered alerts into the alerts table.
6.WeatherController fetches data from both services and passes it to the Thymeleaf templates for display.
7.Thymeleaf Templates (weather_summary.html and alerts.html) visualize the processed data and alerts.
