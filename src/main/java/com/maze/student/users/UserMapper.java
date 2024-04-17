package com.maze.student.users;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    SystemUsers toUsers(UserDto userDto);
    UserDto toUsersDto(SystemUsers users);
}
