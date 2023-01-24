package com.maze.student.Appeal;


import com.maze.student.util.Auditable;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "appeal")
@Data
@Where(clause = "deleted=0")
@SQLDelete(sql = "UPDATE appeal SET deleted = 1 WHERE id=? and version=?")
public class Appeal extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appealId;
    private String fileNumber;
    private String disputedAmount;
    private String courtAdjudicating;
    private String reason;
}
