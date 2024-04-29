package com.maze.student.Sections.Traffics;

import com.maze.student.util.Auditable;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrafficDtos extends Auditable {
    private Long id;
    private  Times eightTime;
    private  String eightTimeTraffic;
    private  Times fortiethTime;
    private  String fortiethTimeTraffic;
    private  Times eighteenTime;
    private  String eighteenTimeTraffic;
    private  String description;
    private LocalDateTime fixedAt;
}
