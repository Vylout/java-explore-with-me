package ru.practicum.location.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationDto {
    private Float lat;
    private Float lon;
}
