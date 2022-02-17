package com.maze.student.Role;

 import com.maze.student.users.models.ERole;
 import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
public class RolesDTO extends RepresentationModel<RolesDTO> {
    private final Long id;
    private ERole name;


    public RolesDTO(Long id,  ERole name) {
        this.id=id;
        this.name = name;
    }
}
