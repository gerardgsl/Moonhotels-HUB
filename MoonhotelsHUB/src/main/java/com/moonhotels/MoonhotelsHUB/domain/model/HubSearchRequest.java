package com.moonhotels.MoonhotelsHUB.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HubSearchRequest {
    private int hotelId;
    private String checkIn;
    private String checkOut;
    private int numberOfGuests;
    private int numberOfRooms;
    private String currency;   	
}