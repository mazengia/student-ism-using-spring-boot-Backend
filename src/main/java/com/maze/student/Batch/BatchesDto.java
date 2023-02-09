package com.maze.student.Batch;

import com.maze.student._config.util.Auditable;
import lombok.Data;

@Data
public class BatchesDto extends Auditable {
    private Long id;
    private String name;
}
