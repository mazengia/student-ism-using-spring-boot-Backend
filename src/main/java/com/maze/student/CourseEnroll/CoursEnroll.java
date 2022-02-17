package com.maze.student.CourseEnroll;

import com.maze.student.Dpt.Dpt;
import com.maze.student.course.Course;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(uniqueConstraints={ @UniqueConstraint(columnNames = {"batch","dptId","semester","dptId","courseId" })})

public class CoursEnroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    int batch;
    String semester;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dptId", referencedColumnName = "id")
    private Dpt dpt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId", referencedColumnName = "id")
    private Course course;

}
