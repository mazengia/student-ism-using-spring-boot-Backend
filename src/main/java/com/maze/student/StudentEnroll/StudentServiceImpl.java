package com.maze.student.StudentEnroll;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Service;

import static com.maze.student.util.Util.getNullPropertyNames;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public Page<StudentEnrolment> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }


    @Override
    public Page<StudentEnrolment> findAllEnrolledByDptId(long dptId, Pageable pageable) {
        return studentRepository.findByStudentDptId(dptId,pageable);
    }

    @Override
    public StudentEnrolment enrollStudent(StudentEnrolment studentEnrolment) {
        return  studentRepository.save(studentEnrolment);
    }

    @Override
    public StudentEnrolment findStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    @Override
    public StudentEnrolment updateStudent(long id, StudentEnrolment studentEnrolment) {
        StudentEnrolment oldData = studentRepository.findById(id);
        if (oldData != null) {
            BeanUtils.copyProperties(studentEnrolment,oldData,getNullPropertyNames(studentEnrolment));
            return  enrollStudent(oldData);
        }
        return null;    }
}
