package com.bezkoder.student.course;
import com.bezkoder.student.department.Department;
import com.bezkoder.student.CourseEnroll.CoursEnroll;
import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"department"})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(unique = true)
    private  String name;
    @Column(unique = true)
    private  String code;
    private  int creditHour;
    private int ects;

    @ManyToOne
    @JoinColumn(  name = "departmentId" )
    private Department department;

    @OneToOne(mappedBy = "course")
    private CoursEnroll courseEnroll;
}
