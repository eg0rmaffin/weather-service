package ru.hawkingbros.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.hawkingbros.model.Message;
import ru.hawkingbros.model.WeatherData;
import ru.hawkingbros.config.ApiConfig;

@Service
public class AdapterService {

    private final RestTemplate restTemplate;
    private final ApiConfig apiConfig; 
    private final String weatherApiUrl = "https://api.gismeteo.net/v2/weather/current";

    public AdapterService(RestTemplate restTemplate, ApiConfig apiConfig) {
        this.restTemplate = restTemplate;
        this.apiConfig = apiConfig;
    }

    public String processMessage(Message message) {
        if (message.getMsg() == null || message.getMsg().trim().isEmpty()) {
            throw new IllegalArgumentException("Message content is empty");
        }

        if ("ru".equalsIgnoreCase(message.getLng())) {
            WeatherData weatherData = getWeatherData(message.getLatitude(), message.getLongitude());
            message.setWeatherData(weatherData);
            return "Message processed with weather data";
        }
        return "Message ignored due to language";
    }

    private WeatherData getWeatherData(double latitude, double longitude) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(weatherApiUrl)
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .queryParam("lang", "ru");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Gismeteo-Token", apiConfig.getApiToken());
        headers.set("Accept-Encoding", "deflate, gzip");

        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<WeatherData> response = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                entity,
                WeatherData.class
        );

        return response.getBody();
    }
}
