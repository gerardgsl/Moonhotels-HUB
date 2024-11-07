package com.moonhotels.MoonhotelsHUB.application.service;

import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchRequest;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchResponse;
import com.moonhotels.MoonhotelsHUB.domain.port.in.SearchHotelUseCase;
import com.moonhotels.MoonhotelsHUB.domain.port.out.HotelProviderPort;
import com.moonhotels.MoonhotelsHUB.domain.service.AggregationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchHotelService implements SearchHotelUseCase {

    private final List<HotelProviderPort> hotelProviders;
    private final AggregationService aggregationService;

    public SearchHotelService(List<HotelProviderPort> hotelProviders, AggregationService aggregationService) {
        this.hotelProviders = hotelProviders;
        this.aggregationService = aggregationService;
    }

    @Override
    public HubSearchResponse searchHotels(HubSearchRequest request) {
    	List<HubSearchResponse> responses = hotelProviders.stream()
    		    .map((HotelProviderPort provider) -> provider.searchAvailability(request))
    		    .collect(Collectors.toList());
        return aggregationService.aggregate(responses);
    }
}
