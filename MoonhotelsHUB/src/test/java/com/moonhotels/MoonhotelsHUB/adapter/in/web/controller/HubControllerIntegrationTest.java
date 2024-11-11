package com.moonhotels.MoonhotelsHUB.adapter.in.web.controller;

import com.moonhotels.MoonhotelsHUB.MoonhotelsHubApplication;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchRequest;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

@SpringBootTest(classes = MoonhotelsHubApplication.class)
@AutoConfigureMockMvc
class HubControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSearchHotels_withValidRequest() throws Exception {
    	LocalDate checkIn = LocalDate.of(2024, 10, 20);
        LocalDate checkOut = LocalDate.of(2024, 10, 25);
        HubSearchRequest validRequest = new HubSearchRequest(1, checkIn, checkOut, 2, 1, "USD");
        
        mockMvc.perform(post("/api/hub/search")
                        .contentType("application/json")
                        .content("{\"hotelId\":1, \"checkIn\":\"2024-11-01\", \"checkOut\":\"2024-11-05\", \"numberOfGuests\":2, \"numberOfRooms\":1, \"currency\":\"USD\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void testSearchHotels_withInvalidRequest() throws Exception {

        mockMvc.perform(post("/api/hub/search")
                        .contentType("application/json")
                        .content("{\"hotelId\":1, \"checkIn\":\"2024-11-01\", \"checkOut\":\"invalid-date\", \"numberOfGuests\":2, \"numberOfRooms\":1, \"currency\":\"USD\"}"))
                .andExpect(status().isBadRequest()); 
    }
}
