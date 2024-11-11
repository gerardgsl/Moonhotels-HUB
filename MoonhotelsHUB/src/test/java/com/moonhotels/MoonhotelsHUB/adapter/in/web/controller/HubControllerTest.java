package com.moonhotels.MoonhotelsHUB.adapter.in.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchRequest;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchResponse;
import com.moonhotels.MoonhotelsHUB.domain.port.in.SearchHotelUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HubControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchHotelUseCase searchHotelUseCase;

    @Test
    void testSearchHotelsWithRates() throws Exception {
       
        LocalDate checkIn = LocalDate.of(2018, 10, 20);
        LocalDate checkOut = LocalDate.of(2018, 10, 25);
        HubSearchRequest request = new HubSearchRequest(1, checkIn, checkOut, 3, 2, "EUR");
      
        HubSearchResponse response = new HubSearchResponse();

        HubSearchResponse.Room room1 = new HubSearchResponse.Room();
        room1.setRoomId(1);

        List<HubSearchResponse.Rate> rates1 = new ArrayList<>();
        HubSearchResponse.Rate rate1 = new HubSearchResponse.Rate();
        rate1.setMealPlanId(1);
        rate1.setPrice(123.48);
        rate1.setCancellable(false);
        rates1.add(rate1);

        HubSearchResponse.Rate rate2 = new HubSearchResponse.Rate();
        rate2.setMealPlanId(1);
        rate2.setPrice(150.0);
        rate2.setCancellable(true);
        rates1.add(rate2);

        room1.setRates(rates1);

        HubSearchResponse.Room room2 = new HubSearchResponse.Room();
        room2.setRoomId(2);

        List<HubSearchResponse.Rate> rates2 = new ArrayList<>();
        HubSearchResponse.Rate rate3 = new HubSearchResponse.Rate();
        rate3.setMealPlanId(1);
        rate3.setPrice(148.25);
        rate3.setCancellable(false);
        rates2.add(rate3);

        HubSearchResponse.Rate rate4 = new HubSearchResponse.Rate();
        rate4.setMealPlanId(2);
        rate4.setPrice(165.38);
        rate4.setCancellable(false);
        rates2.add(rate4);

        room2.setRates(rates2);

        response.setRooms(Arrays.asList(room1, room2));

        when(searchHotelUseCase.searchHotels(request)).thenReturn(response);
        
        mockMvc.perform(post("/api/hub/search")
                .contentType("application/json")
                .content(asJsonString(request)))
                .andExpect(status().isOk());
    }
    
    private String asJsonString(final Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
