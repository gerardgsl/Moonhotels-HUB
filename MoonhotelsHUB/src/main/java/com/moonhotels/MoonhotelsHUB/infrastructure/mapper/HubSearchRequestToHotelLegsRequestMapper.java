package com.moonhotels.MoonhotelsHUB.infrastructure.mapper;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.moonhotels.MoonhotelsHUB.adapter.out.hotellegs.HotelLegsRequest;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchRequest;

@Mapper
public interface HubSearchRequestToHotelLegsRequestMapper {
	HubSearchRequestToHotelLegsRequestMapper INSTANCE = Mappers.getMapper(HubSearchRequestToHotelLegsRequestMapper.class);

	default HotelLegsRequest mapToHotelRequest(HubSearchRequest hubSearchRequest) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        int numberOfNights = (int) ChronoUnit.DAYS.between(hubSearchRequest.getCheckIn(), hubSearchRequest.getCheckOut());
        
        return new HotelLegsRequest(
                hubSearchRequest.getHotelId(),
                hubSearchRequest.getCheckIn(),
                numberOfNights,
                hubSearchRequest.getNumberOfGuests(),
                hubSearchRequest.getNumberOfRooms(),
                hubSearchRequest.getCurrency()
        );
	}    
}
