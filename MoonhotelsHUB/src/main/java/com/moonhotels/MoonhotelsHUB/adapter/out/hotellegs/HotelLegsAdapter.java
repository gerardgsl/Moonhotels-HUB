package com.moonhotels.MoonhotelsHUB.adapter.out.hotellegs;

import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchRequest;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchResponse;
import com.moonhotels.MoonhotelsHUB.domain.port.out.HotelProviderPort;
import org.springframework.stereotype.Component;

@Component
public class HotelLegsAdapter implements HotelProviderPort {

 private final MockHotelLegsAPI mockHotelLegsAPI;

 public HotelLegsAdapter(MockHotelLegsAPI mockHotelLegsAPI) {
     this.mockHotelLegsAPI = mockHotelLegsAPI;
 }

 @Override
 public HubSearchResponse searchAvailability(HubSearchRequest request) {
     return mockHotelLegsAPI.search(request);
 }
}
