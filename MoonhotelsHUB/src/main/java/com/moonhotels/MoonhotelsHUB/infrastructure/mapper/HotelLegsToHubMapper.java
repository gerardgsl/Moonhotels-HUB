package com.moonhotels.MoonhotelsHUB.infrastructure.mapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.moonhotels.MoonhotelsHUB.adapter.out.hotellegs.HotelLegsResponse;
import com.moonhotels.MoonhotelsHUB.domain.model.HubSearchResponse;

@Mapper
public interface HotelLegsToHubMapper {
    HotelLegsToHubMapper INSTANCE = Mappers.getMapper(HotelLegsToHubMapper.class);

    default HubSearchResponse toHubSearchResponse(HotelLegsResponse hotelLegsResponse) {

        Map<Integer, List<HotelLegsResponse.Result>> groupedByRoom = hotelLegsResponse.getResults().stream()
            .collect(Collectors.groupingBy(HotelLegsResponse.Result::getRoom));

        List<HubSearchResponse.Room> rooms = groupedByRoom.entrySet().stream()
            .map(entry -> {
                HubSearchResponse.Room room = new HubSearchResponse.Room();
                room.setRoomId(entry.getKey());
                room.setRates(toRateList(entry.getValue()));
                return room;
            })
            .collect(Collectors.toList());

        HubSearchResponse response = new HubSearchResponse();
        response.setRooms(rooms);
        return response;
    }

    default List<HubSearchResponse.Rate> toRateList(List<HotelLegsResponse.Result> results) {
        return results.stream()
            .map(this::toRate) 
            .collect(Collectors.toList()); 
    }

    @Mapping(source = "meal", target = "mealPlanId")
    @Mapping(source = "canCancel", target = "cancellable")
    HubSearchResponse.Rate toRate(HotelLegsResponse.Result result);
}