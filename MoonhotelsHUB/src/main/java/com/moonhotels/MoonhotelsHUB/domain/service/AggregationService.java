package com.moonhotels.MoonhotelsHUB.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchResponse;

public class AggregationService {
    public HubSearchResponse aggregate(List<HubSearchResponse> responses) {
        HubSearchResponse aggregatedResponse = new HubSearchResponse();
        aggregatedResponse.setRooms(responses.stream()
                                             .flatMap(response -> response.getRooms().stream())
                                             .collect(Collectors.toList()));
        return aggregatedResponse;
    }
}
