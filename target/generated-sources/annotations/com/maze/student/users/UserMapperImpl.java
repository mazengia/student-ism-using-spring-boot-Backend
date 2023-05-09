package com.maze.student.users;

import com.maze.student.Role.Roles;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T15:25:50+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public SystemUsers toUsers(UserDto userDto) {
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
        systemUsers.setFirstName( userDto.getFirstName() );
        systemUsers.setLastName( userDto.getLastName() );
        systemUsers.setEmail( userDto.getEmail() );
        systemUsers.setPassword( userDto.getPassword() );
        Set<Roles> set = userDto.getRole();
        if ( set != null ) {
            systemUsers.setRole( new LinkedHashSet<Roles>( set ) );
        }
        systemUsers.setDpt( userDto.getDpt() );

        return systemUsers;
    }

    @Override
    public UserDto toUsersDto(ResponseEntity<MessageResponse> users) {
        if ( users == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        return userDto;
    }

    @Override
    public UserDto toGetUsersDto(SystemUsers systemUsers) {
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
        userDto.setFirstName( systemUsers.getFirstName() );
        userDto.setLastName( systemUsers.getLastName() );
        userDto.setEmail( systemUsers.getEmail() );
        userDto.setPassword( systemUsers.getPassword() );
        userDto.setDpt( systemUsers.getDpt() );
        Set<Roles> set = systemUsers.getRole();
        if ( set != null ) {
            userDto.setRole( new LinkedHashSet<Roles>( set ) );
        }

        return userDto;
    }
}
