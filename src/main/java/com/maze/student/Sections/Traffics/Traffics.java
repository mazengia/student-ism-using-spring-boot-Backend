package com.maze.student.Sections.Traffics;


import com.maze.student.util.Auditable;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "traffics")
@Data
@Where(clause = "deleted=0")
@SQLDelete(sql = "UPDATE traffics SET deleted = 1 WHERE id=? and version=?")
public class Traffics extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false)
    private  Times eightTime;
    private  String eightTimeTraffic;
    @Column(nullable = false, updatable = false)
    private  Times fortiethTime;
    private  String fortiethTimeTraffic;
    @Column(nullable = false, updatable = false)
    private  Times eighteenTime;
    private  String eighteenTimeTraffic;
    private  String description;
    private LocalDateTime fixedAt;
}
