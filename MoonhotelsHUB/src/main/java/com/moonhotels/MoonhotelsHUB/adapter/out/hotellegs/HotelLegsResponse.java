package com.moonhotels.MoonhotelsHUB.adapter.out.hotellegs;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelLegsResponse {
    private List<Result> results;

    @Getter
    @Setter
    public static class Result {
        private int room;
        private int meal;
        private boolean canCancel;
        private double price;
    }
}
