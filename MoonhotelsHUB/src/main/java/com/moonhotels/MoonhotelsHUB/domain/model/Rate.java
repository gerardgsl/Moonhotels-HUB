package com.moonhotels.MoonhotelsHUB.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rate {
    private int mealPlanId;
    @JsonProperty("isCancellable")
    private boolean isCancellable;
    private double price;   
}