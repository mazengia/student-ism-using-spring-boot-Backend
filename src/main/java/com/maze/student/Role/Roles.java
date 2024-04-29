package com.maze.student.Role;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private  String name;

}
