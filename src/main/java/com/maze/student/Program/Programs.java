package com.maze.student.Program;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Programs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    String name;

}
