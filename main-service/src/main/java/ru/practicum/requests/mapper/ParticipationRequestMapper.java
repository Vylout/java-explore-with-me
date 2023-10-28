package ru.practicum.requests.mapper;

import ru.practicum.requests.model.dto.ParticipationRequestDto;
import ru.practicum.requests.model.entity.ParticipationRequest;

import java.util.ArrayList;
import java.util.List;

public class ParticipationRequestMapper {
    public static ParticipationRequestDto toRequestDto(ParticipationRequest participationRequest) {
        return ParticipationRequestDto.builder()
                .created(participationRequest.getCreated())
                .event(participationRequest.getEvent().getId())
                .id(participationRequest.getId())
                .requester(participationRequest.getId())
                .status(participationRequest.getStatus())
                .build();
    }

    public static List<ParticipationRequestDto> toRequestDto(Iterable<ParticipationRequest> eventRequests) {
        List<ParticipationRequestDto> result = new ArrayList<>();

        for (ParticipationRequest request : eventRequests) {
            result.add(toRequestDto(request));
        }

        return result;
    }
}
