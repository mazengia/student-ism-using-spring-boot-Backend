package com.maze.student.course;

import com.maze.student.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import static com.maze.student.util.Util.getNullPropertyNames;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;
    CourseAssembler courseAssembler;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public CollectionModel<CourseDTO> findAll(int page, int size) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size);
        Page<Course> courses = courseRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(courses.getContent()))
            return pagedResourcesAssembler.toModel(courses, courseAssembler);

        return null;
    }

    @Override
    public CourseDTO addCourse(Course course) {
        return courseAssembler.toModel(courseRepository.save(course));
    }

    @Override
    public CourseDTO findCourseById(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            return courseAssembler.toModel(course);
        }
        return null;
    }

    @Override
    public CourseDTO updateCourse(Long id, Course course) {
        Course oldData = courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Course.class, "Id", String.valueOf(id)));
        if (oldData != null) {
            BeanUtils.copyProperties(course, oldData, getNullPropertyNames(course));
            return addCourse(oldData);
        }
        return null;
    }

    @Override
    public CourseDTO deleteCourseById(Long id) {
         courseRepository.deleteById(id);
         return null;
    }
}
