package com.moonhotels.MoonhotelsHUB.adapter.in.web.controller;

import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchRequest;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchResponse;
import com.moonhotels.MoonhotelsHUB.domain.port.in.SearchHotelUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/hub")
public class HubController {

    @Autowired
    private SearchHotelUseCase searchHotelUseCase;
    
    @Autowired
    public HubController(SearchHotelUseCase searchHotelUseCase) {
        this.searchHotelUseCase = searchHotelUseCase;
    }
    
    @Operation(summary = "Search for available hotels")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of hotels",
            content = { @Content(mediaType = "application/json",
                schema = @Schema(implementation = HubSearchResponse.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid search parameters",
            content = @Content),        
    })
    @PostMapping("/search")
    public HubSearchResponse searchHotels(@RequestBody HubSearchRequest request) {
        return searchHotelUseCase.searchHotels(request);
    }
}
