package com.maze.student.users;

import org.mapstruct.Mapper;
import org.springframework.http.ResponseEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    SystemUsers toStudents(UserDto userDto);
    SignupRequest toCreateStudents(UserDto userDto);
    UserDto toStudentsDto(ResponseEntity<MessageResponse> students);
    UserDto toGetStudentsDto(SystemUsers systemUsers);
}
