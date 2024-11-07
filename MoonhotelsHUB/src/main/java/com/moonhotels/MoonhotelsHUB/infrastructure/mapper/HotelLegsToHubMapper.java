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

    // Mapea HotelLegsResponse a HubSearchResponse
    default HubSearchResponse toHubSearchResponse(HotelLegsResponse hotelLegsResponse) {
        // Agrupar los resultados por la habitación (room)
        Map<Integer, List<HotelLegsResponse.Result>> groupedByRoom = hotelLegsResponse.getResults().stream()
            .collect(Collectors.groupingBy(HotelLegsResponse.Result::getRoom));

        // Convertir las habitaciones agrupadas en una lista de Room para HubSearchResponse
        List<HubSearchResponse.Room> rooms = groupedByRoom.entrySet().stream()
            .map(entry -> {
                HubSearchResponse.Room room = new HubSearchResponse.Room();
                room.setRoomId(entry.getKey());
                room.setRates(toRateList(entry.getValue())); // Convertir los resultados a tarifas
                return room;
            })
            .collect(Collectors.toList()); // Asegurarse de que se recoja una lista

        // Crear el HubSearchResponse y asignar las habitaciones
        HubSearchResponse response = new HubSearchResponse();
        response.setRooms(rooms);
        return response;
    }

    // Convertir la lista de Result a Rate
    default List<HubSearchResponse.Rate> toRateList(List<HotelLegsResponse.Result> results) {
        return results.stream()
            .map(this::toRate) // Mapea cada Result a Rate
            .collect(Collectors.toList()); // Recoge los Rates mapeados en una lista
    }

    // Mapea de Result a Rate
    @Mapping(source = "meal", target = "mealPlanId")
    @Mapping(source = "canCancel", target = "isCancellable")
    HubSearchResponse.Rate toRate(HotelLegsResponse.Result result);
}