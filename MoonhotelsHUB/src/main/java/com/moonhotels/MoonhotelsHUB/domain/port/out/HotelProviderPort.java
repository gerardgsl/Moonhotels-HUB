package com.moonhotels.MoonhotelsHUB.domain.port.out;

import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchRequest;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchResponse;

public interface HotelProviderPort {
    HubSearchResponse fetchHotelAvailability(HubSearchRequest request);
}
