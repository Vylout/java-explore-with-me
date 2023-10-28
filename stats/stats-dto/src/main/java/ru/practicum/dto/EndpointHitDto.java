package ru.practicum.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EndpointHitDto {

    private Long id;
    @NotBlank(message = "App не может быть пустым")
    private String app;
    @NotBlank(message = "Uri не может быть пустым")
    private String uri;
    @NotBlank(message = "Ip не может быть пустым")
    private String ip;
    @NotNull(message = "Timestamp не может быть пустым")
    private String timestamp;
}
