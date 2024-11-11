package com.moonhotels.MoonhotelsHUB.adapter.out.hotellegs;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchResponse;
import com.moonhotels.MoonhotelsHUB.infrastructure.mapper.HotelLegsToHubMapper;

@Component
public class MockHotelLegsAPI {
    public HubSearchResponse search(HotelLegsRequest request) {
    	HubSearchResponse searchResponse = new HubSearchResponse();
    	if(ValidMock(request))
    	{
	    	HotelLegsResponse response = MockHotelLegsResponse();
	    	searchResponse = HotelLegsToHubMapper.INSTANCE.toHubSearchResponse(response);
    	}
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
    
    private boolean ValidMock(HotelLegsRequest request)
    {
    	LocalDate checkInDate = LocalDate.of(2018,10,20);
    	
    	if(request.getHotel() == 1 && request.getCheckInDate().isEqual(checkInDate) 
    			&& request.getNumberOfNights() == 5 && request.getGuests() == 3 
    			&& request.getRooms() == 2)
    		return true;
    	return false;
    }
}