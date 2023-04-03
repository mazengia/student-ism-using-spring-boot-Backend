package com.maze.student.CerteficationYear;

import com.maze.student._config.util.Auditable;
import lombok.Data;

@Data
public class CertificationYearDto extends Auditable {
    private Long id;
    private String name;
}
