package com.techelevator.locations.model.Services;

import com.techelevator.locations.model.Planets.PlanetMinSize1;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PlanetService {
    //TODO: incorp more planets.
    private static final String API_BASE_URL = "https://api.api-ninjas.com/v1/planets?";
    private final RestTemplate restTemplate = new RestTemplate();


    public PlanetMinSize1[] planetMinSize1List(){
         PlanetMinSize1[] planetList = null;
        try {
            planetList = restTemplate.getForObject(API_BASE_URL + "max_mass=1", PlanetMinSize1[].class);
        } catch (RestClientResponseException e) {
            // handles exceptions thrown by rest template and contains status codes
            System.out.println(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            // i/o error, ex: the server isn't running
            System.out.println(e.getMessage());
        }
        return planetList;
    }
}
