package com.maze.student.StudentEnroll;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;
    StudentAssembler studentAssembler;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public CollectionModel<StudentDTO> findAll(int page, int size) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size);
        Page<StudentEnrolment> studentEnrolments = studentRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(studentEnrolments.getContent()))
            return pagedResourcesAssembler.toModel(studentEnrolments, studentAssembler);

        return null;
    }

    @Override
    public StudentDTO addStudent(StudentEnrolment studentEnrolment) {
        return studentAssembler.toModel(studentRepository.save(studentEnrolment));
    }

    @Override
    public StudentDTO findStudentById(Long id) {
        StudentEnrolment studentEnrolment = studentRepository.findById(id).orElse(null);
        if (studentEnrolment != null) {
            return studentAssembler.toModel(studentEnrolment);
        }
        return null;
    }
}
