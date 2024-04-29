package com.maze.student.failedTraffic;


import com.maze.student.util.Auditable;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "failed_traffics")
@Data
@Where(clause = "deleted=0")
@SQLDelete(sql = "UPDATE failed_traffics SET deleted = 1 WHERE id=? and version=?")
public class FailedTraffics extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String failedSite;
    private  String failedLinkType;
    private  String failedReason;
    private  String reportedTo;
    private LocalDateTime failedAt;
    private LocalDateTime fixedAt;
}
