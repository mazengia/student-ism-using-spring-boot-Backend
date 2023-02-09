package com.maze.student.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Department", indexes = {
        @Index(name = "idx_department_id", columnList = "id")
})
@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, name="name")
    private String name;
    @Column(unique = true, name="code")
    private String code;


}
