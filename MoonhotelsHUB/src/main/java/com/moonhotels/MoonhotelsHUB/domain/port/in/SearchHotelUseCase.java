package com.moonhotels.MoonhotelsHUB.domain.port.in;

import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchRequest;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchResponse;

public interface SearchHotelUseCase {
    HubSearchResponse searchHotels(HubSearchRequest request);
}