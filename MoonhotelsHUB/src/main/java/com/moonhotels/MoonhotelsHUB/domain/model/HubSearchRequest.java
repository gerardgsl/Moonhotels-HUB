package com.moonhotels.MoonhotelsHUB.domain.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HubSearchRequest {
	@Schema(description = "ID of the hotel", example = "1")
    private int hotelId;
	@Schema(description = "Check-in date", example = "2018-10-20")
    private LocalDate checkIn;
	@Schema(description = "Check-out date", example = "2018-10-25")
    private LocalDate checkOut;
	@Schema(description = "Number of guests", example = "3")
    private int numberOfGuests;
	@Schema(description = "Number of rooms", example = "2")
    private int numberOfRooms;
	@Schema(description = "Currency", example = "EUR")
    private String currency;   	
}