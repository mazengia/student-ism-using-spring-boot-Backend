package com.maze.student.failedTraffic;

import com.maze.student.util.Auditable;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FailedTrafficDtos extends Auditable {
    private Long id;
    private String failedSite;
    private  String failedLinkType;
    private  String failedReason;
    private  String reportedTo;
    private LocalDateTime failedAt;
    private LocalDateTime fixedAt;
}
