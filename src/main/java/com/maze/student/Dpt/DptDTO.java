package com.maze.student.Dpt;

import com.maze.student.CertificationType.Certifications;
import com.maze.student.Department.Department;
import com.maze.student.Program.Programs;
import com.maze.student._config.util.Auditable;
import lombok.Data;

@Data
public class DptDTO extends Auditable {

    private final Long id;
    private final Department department;
    private final Programs programs;
    private final Certifications certifications;

}
