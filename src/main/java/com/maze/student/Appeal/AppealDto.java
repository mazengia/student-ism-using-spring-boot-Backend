package com.maze.student.Appeal;

import com.maze.student.util.Auditable;
import lombok.Data;

@Data
public class AppealDto extends Auditable {
    private Long appealId;
    private String reason;
    private String fileNumber;
    private String courtAdjudicating;
    private String disputedAmount;
}
