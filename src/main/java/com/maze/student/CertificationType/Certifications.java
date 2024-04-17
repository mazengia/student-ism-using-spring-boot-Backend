package com.maze.student.CertificationType;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Certifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
}
