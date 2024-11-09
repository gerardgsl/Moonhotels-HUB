package com.moonhotels.MoonhotelsHUB.adapter.out.hotellegs;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HotelLegsRequest {
	private int hotel;
    private String checkInDate;
    private int numberOfNights;
    private int guests;
    private int rooms;
    private String currency;
}
