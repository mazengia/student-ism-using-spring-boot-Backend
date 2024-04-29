package com.maze.student.users;

import com.maze.student.Role.Roles;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T12:44:30+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
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
    public UserDto toUsersDto(SystemUsers users) {
        if ( users == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setDeletedAt( users.getDeletedAt() );
        userDto.setDeleted( users.isDeleted() );
        userDto.setVersion( users.getVersion() );
        userDto.setCreatedBy( users.getCreatedBy() );
        userDto.setUpdatedBy( users.getUpdatedBy() );
        userDto.setCreatedAt( users.getCreatedAt() );
        userDto.setUpdatedAt( users.getUpdatedAt() );
        userDto.setRemark( users.getRemark() );
        userDto.setId( users.getId() );
        userDto.setUsername( users.getUsername() );
        userDto.setFirstName( users.getFirstName() );
        userDto.setLastName( users.getLastName() );
        userDto.setEmail( users.getEmail() );
        userDto.setPassword( users.getPassword() );
        userDto.setDpt( users.getDpt() );
        Set<Roles> set = users.getRole();
        if ( set != null ) {
            userDto.setRole( new LinkedHashSet<Roles>( set ) );
        }

        return userDto;
    }
}
