package com.moonhotels.MoonhotelsHUB.adapter.out.hotellegs;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchResponse;
import com.moonhotels.MoonhotelsHUB.infrastructure.mapper.HotelLegsToHubMapper;

@Component
public class MockHotelLegsAPI {
    public HubSearchResponse search(HotelLegsRequest request) {
    	
    	HotelLegsResponse response = MockHotelLegsResponse();
    	HubSearchResponse searchResponse = HotelLegsToHubMapper.INSTANCE.toHubSearchResponse(response);

    	return searchResponse;
    }
    
    private HotelLegsResponse MockHotelLegsResponse()
    {
    	File file = new File("src/main/resources/hotelLegsResponse.json");
        ObjectMapper objectMapper = new ObjectMapper();
        HotelLegsResponse hotelLegsResponse = new HotelLegsResponse();
        
        try {
            hotelLegsResponse = objectMapper.readValue(file, HotelLegsResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    	return hotelLegsResponse;
    }
}