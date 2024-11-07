package com.moonhotels.MoonhotelsHUB.adapter.in.web.controller;

import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchRequest;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchResponse;
import com.moonhotels.MoonhotelsHUB.domain.port.in.SearchHotelUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hub")
public class HubController {

    private final SearchHotelUseCase searchHotelUseCase;

    public HubController(SearchHotelUseCase searchHotelUseCase) {
        this.searchHotelUseCase = searchHotelUseCase;
    }

    @PostMapping("/search")
    public HubSearchResponse searchHotels(@RequestBody HubSearchRequest request) {
        return searchHotelUseCase.searchHotels(request);
    }
}