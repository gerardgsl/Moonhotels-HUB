package com.moonhotels.MoonhotelsHUB.domain.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HubSearchResponse {

	private List<Room> rooms = new ArrayList<>();

    @Getter
    @Setter
    public static class Room {
        private int roomId;
        private List<Rate> rates;
    }

    @Getter
    @Setter
    public static class Rate {
        private int mealPlanId;
        @JsonProperty("isCancellable")
        private boolean isCancellable;
        private double price;
    }
}
