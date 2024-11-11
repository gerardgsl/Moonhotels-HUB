package com.moonhotels.MoonhotelsHUB.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HubSearchRequest {
    @NotNull(message = "Hotel ID cannot be null")
    @Min(value = 1, message = "Hotel ID must be greater than or equal to 1")
    @Schema(description = "ID of the hotel", example = "1")
    private int hotelId;

    @NotNull(message = "Check-in date cannot be null")
    @Schema(description = "Check-in date", example = "2018-10-20")
    private LocalDate checkIn;

    @NotNull(message = "Check-out date cannot be null")
    @Schema(description = "Check-out date", example = "2018-10-25")
    private LocalDate checkOut;

    @NotNull(message = "Number of guests cannot be null")
    @Min(value = 1, message = "At least one guest is required")
    @Schema(description = "Number of guests", example = "3")
    private int numberOfGuests;

    @NotNull(message = "Number of rooms cannot be null")
    @Min(value = 1, message = "At least one room is required")
    @Schema(description = "Number of rooms", example = "2")
    private int numberOfRooms;

    @NotNull(message = "Currency cannot be null")
    @Size(min = 3, max = 3, message = "Currency should be a 3-letter code")
    @Schema(description = "Currency", example = "EUR")
    private String currency;   	
}