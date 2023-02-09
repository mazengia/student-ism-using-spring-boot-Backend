package com.maze.student.users;

import org.mapstruct.Mapper;
import org.springframework.http.ResponseEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    SystemUsers toUsers(UserDto userDto);
    UserDto toUsersDto(ResponseEntity<MessageResponse> users);
    UserDto toGetUsersDto(SystemUsers systemUsers);
}
