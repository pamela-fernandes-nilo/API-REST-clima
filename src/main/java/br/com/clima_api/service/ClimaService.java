package br.com.clima_api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClimaService {

    private static final String URL_BASE_BH =  "https://api.open-meteo.com/v1/forecast" +
        "?latitude=-19.9208" +
        "&longitude=-43.9378" +
        "&daily=temperature_2m_max,temperature_2m_min,wind_speed_10m_max" +
        "&current=temperature_2m,wind_speed_10m,wind_direction_10m,weather_code,relative_humidity_2m" +
        "&timezone=auto" +
        "&forecast_days=1";
    private static final String URL_BASE_2 = ("https://geocoding-api.open-meteo.com/v1/search?name=");
    

    public String getClimaBH() {
        return consultarURL(URL_BASE_BH);
    }

    public String getClima(String cidade) {
        return consultarURL(URL_BASE_2 + cidade);
    }

    private String consultarURL(String apiUrl){
        String dados = "";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dados = responseEntity.getBody();
        } else {
            dados = "Falha ao obter dados. Código de status: " + responseEntity.getStatusCode();
        }
        return dados;
    }
}