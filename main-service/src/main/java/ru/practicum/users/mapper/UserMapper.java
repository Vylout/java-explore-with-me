package ru.practicum.users.mapper;

import ru.practicum.users.model.dto.NewUserRequest;
import ru.practicum.users.model.dto.UserDto;
import ru.practicum.users.model.dto.UserShortDto;
import ru.practicum.users.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static List<UserDto> toUserDto(Iterable<User> users) {
        List<UserDto> result = new ArrayList<>();

        for (User user : users) {
            result.add(toUserDto(user));
        }

        return result;
    }

    public static User toUser(NewUserRequest newUserRequest) {
        return User.builder()
                .name(newUserRequest.getName())
                .email(newUserRequest.getEmail())
                .build();
    }

    public static UserShortDto toUserShortDto(User user) {
        return UserShortDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    public static List<UserShortDto> toUserShortDto(Iterable<User> users) {
        List<UserShortDto> result = new ArrayList<>();

        for (User user : users) {
            result.add(toUserShortDto(user));
        }

        return result;
    }
}
