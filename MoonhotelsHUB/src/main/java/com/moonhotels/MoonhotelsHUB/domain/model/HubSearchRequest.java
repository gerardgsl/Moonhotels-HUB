package com.moonhotels.MoonhotelsHUB.domain.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HubSearchRequest {
    private int hotelId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int numberOfGuests;
    private int numberOfRooms;
    private String currency;   	
}