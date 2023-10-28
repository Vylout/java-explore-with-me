package ru.practicum.location.mapper;

import ru.practicum.location.model.dto.LocationDto;
import ru.practicum.location.model.entity.Location;

public class LocationMapper {
    public static LocationDto toLocationDto(Location location) {
        return LocationDto.builder()
                .lat(location.getLat())
                .lon(location.getLon())
                .build();
    }
}
