package com.maze.student.users;

import com.maze.student.Dpt.Dpt;
import com.maze.student.Role.Roles;
import com.maze.student.util.Auditable;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto extends Auditable {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Dpt dpt;
    private Set<Roles> role;
}
