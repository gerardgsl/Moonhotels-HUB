package com.moonhotels.MoonhotelsHUB.adapter.out.hotellegs;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchRequest;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchResponse;
import com.moonhotels.MoonhotelsHUB.infrastructure.mapper.HotelLegsToHubMapper;

import org.springframework.stereotype.Component;

@Component
public class MockHotelLegsAPI {
    public HubSearchResponse search(HubSearchRequest request) {
    	
    	HotelLegsResponse response = MockHotelLegsResponse();
    	HubSearchResponse searchResponse = HotelLegsToHubMapper.INSTANCE.toHubSearchResponse(response);

    	return searchResponse;
    }
    
    private HotelLegsResponse MockHotelLegsResponse()
    {
    	File file = new File("src/main/resources/hotelLegsResponse.json");
    	// Crear el ObjectMapper de Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        HotelLegsResponse hotelLegsResponse = new HotelLegsResponse();
        try {
            // Leer el archivo JSON y convertirlo a HotelLegsResponse
            hotelLegsResponse = objectMapper.readValue(file, HotelLegsResponse.class);

            // Imprimir el resultado para verificar
            System.out.println("HotelLegsResponse:");
            hotelLegsResponse.getResults().forEach(result -> {
                System.out.println("Room: " + result.getRoom());
                System.out.println("Meal: " + result.getMeal());
                System.out.println("CanCancel: " + result.isCanCancel());
                System.out.println("Price: " + result.getPrice());
                System.out.println();
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    	return hotelLegsResponse;
    }
}