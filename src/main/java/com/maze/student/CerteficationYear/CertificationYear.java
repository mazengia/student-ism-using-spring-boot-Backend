package com.maze.student.CerteficationYear;


import com.maze.student.util.Auditable;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
