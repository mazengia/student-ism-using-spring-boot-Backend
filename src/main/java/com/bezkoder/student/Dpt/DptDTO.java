package com.bezkoder.student.Dpt;

import com.bezkoder.student.ProgramType.ProgramType;
import com.bezkoder.student.department.Department;
import com.bezkoder.student.program.Programs;
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
    private final ProgramType programType;
    private final Programs programs;

}
