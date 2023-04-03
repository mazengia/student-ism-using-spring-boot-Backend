package com.maze.student.CerteficationYear;


import com.maze.student._config.util.Auditable;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Data
@Where(clause = "deleted=0")
@SQLDelete(sql = "UPDATE certificationYear SET deleted = 1 WHERE id=? and version=?")
public class CertificationYear extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
