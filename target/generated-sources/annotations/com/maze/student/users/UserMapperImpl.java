package com.maze.student.users;

import javax.annotation.processing.Generated;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-24T17:25:32+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public SystemUsers toStudents(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        SystemUsers systemUsers = new SystemUsers();

        systemUsers.setDeletedAt( userDto.getDeletedAt() );
        systemUsers.setDeleted( userDto.isDeleted() );
        systemUsers.setVersion( userDto.getVersion() );
        systemUsers.setCreatedBy( userDto.getCreatedBy() );
        systemUsers.setUpdatedBy( userDto.getUpdatedBy() );
        systemUsers.setCreatedAt( userDto.getCreatedAt() );
        systemUsers.setUpdatedAt( userDto.getUpdatedAt() );
        systemUsers.setRemark( userDto.getRemark() );
        systemUsers.setId( userDto.getId() );
        systemUsers.setUsername( userDto.getUsername() );
        systemUsers.setEmail( userDto.getEmail() );
        systemUsers.setPassword( userDto.getPassword() );
        systemUsers.setDpt( userDto.getDpt() );

        return systemUsers;
    }

    @Override
    public SignupRequest toCreateStudents(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        SignupRequest signupRequest = new SignupRequest();

        signupRequest.setUsername( userDto.getUsername() );
        signupRequest.setDpt( userDto.getDpt() );
        signupRequest.setEmail( userDto.getEmail() );
        signupRequest.setPassword( userDto.getPassword() );

        return signupRequest;
    }

    @Override
    public UserDto toStudentsDto(ResponseEntity<MessageResponse> students) {
        if ( students == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        return userDto;
    }

    @Override
    public UserDto toGetStudentsDto(SystemUsers systemUsers) {
        if ( systemUsers == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setDeletedAt( systemUsers.getDeletedAt() );
        userDto.setDeleted( systemUsers.isDeleted() );
        userDto.setVersion( systemUsers.getVersion() );
        userDto.setCreatedBy( systemUsers.getCreatedBy() );
        userDto.setUpdatedBy( systemUsers.getUpdatedBy() );
        userDto.setCreatedAt( systemUsers.getCreatedAt() );
        userDto.setUpdatedAt( systemUsers.getUpdatedAt() );
        userDto.setRemark( systemUsers.getRemark() );
        userDto.setId( systemUsers.getId() );
        userDto.setUsername( systemUsers.getUsername() );
        userDto.setEmail( systemUsers.getEmail() );
        userDto.setPassword( systemUsers.getPassword() );
        userDto.setDpt( systemUsers.getDpt() );

        return userDto;
    }
}
