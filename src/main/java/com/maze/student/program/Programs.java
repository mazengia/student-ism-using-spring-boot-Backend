package com.maze.student.program;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Programs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
}
