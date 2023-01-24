package com.maze.student.users;

import com.maze.student.Dpt.Dpt;
import com.maze.student.util.Auditable;
import lombok.Data;

@Data
public class UserDto extends Auditable {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Dpt dpt;
}
