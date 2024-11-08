package com.moonhotels.MoonhotelsHUB.infrastructure.mapper;

import java.time.LocalDate;
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
        LocalDate checkInDate = LocalDate.parse(hubSearchRequest.getCheckIn(), formatter);
        LocalDate checkOutDate = LocalDate.parse(hubSearchRequest.getCheckOut(), formatter);
        
        return new HotelLegsRequest(
                hubSearchRequest.getHotelId(),
                hubSearchRequest.getCheckIn(),
                (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate),
                hubSearchRequest.getNumberOfGuests(),
                hubSearchRequest.getNumberOfRooms(),
                hubSearchRequest.getCurrency()
        );
	}    
}
