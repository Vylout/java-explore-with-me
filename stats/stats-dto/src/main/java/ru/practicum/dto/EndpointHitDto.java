package ru.practicum.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

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
    @Past(message = "Timestamp не может быть в будущем")
    @NotNull(message = "Timestamp не может быть пустым")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String timestamp;
}
