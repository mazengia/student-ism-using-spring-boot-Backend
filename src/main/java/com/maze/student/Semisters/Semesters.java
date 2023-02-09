package com.maze.student.Semisters;


import com.maze.student._config.util.Auditable;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "semesters")
@Data
@Where(clause = "deleted=0")
@SQLDelete(sql = "UPDATE semesters SET deleted = 1 WHERE id=? and version=?")
public class Semesters extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
