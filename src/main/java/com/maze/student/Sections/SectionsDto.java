package com.maze.student.Sections;

import com.maze.student.util.Auditable;
import lombok.Data;

@Data
public class SectionsDto extends Auditable {
    private Long id;
    private String name;
}
