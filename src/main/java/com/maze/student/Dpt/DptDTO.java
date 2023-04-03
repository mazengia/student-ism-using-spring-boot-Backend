package com.maze.student.Dpt;

import com.maze.student.Department.Department;
import com.maze.student.Program.Programs;
import com.maze.student.CertificationType.Certifications;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class DptDTO extends RepresentationModel<DptDTO> {

    private final Long id;
    private final Department department;
    private final Programs programs;
    private final Certifications certifications;

}
