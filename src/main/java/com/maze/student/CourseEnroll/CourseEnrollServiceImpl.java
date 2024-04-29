package com.maze.student.CourseEnroll;

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
public class CourseEnrollServiceImpl implements CourseEnrollService {

    CourseEnrollRepository courseEnrollRepository;
    CourseEnrollAssembler courseEnrollAssembler;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public CollectionModel<CourseEnrollDTO> findAll(int page, int size) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size);
        Page<CourseEnroll> courses = courseEnrollRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(courses.getContent()))
            return pagedResourcesAssembler.toModel(courses, courseEnrollAssembler);

        return null;
    }

    @Override
    public CourseEnrollDTO enrollCourse(CourseEnroll courseEnroll) {
        return courseEnrollAssembler.toModel(courseEnrollRepository.save(courseEnroll));
    }

    @Override
    public CourseEnrollDTO findCourseById(Long id) {
        CourseEnroll courseEnroll = courseEnrollRepository.findById(id).orElse(null);
        if (courseEnroll != null) {
            return courseEnrollAssembler.toModel(courseEnroll);
        }
        return null;
    }

    @Override
    public CourseEnrollDTO updateCourseEnroll(Long id, CourseEnroll courseEnroll) {
        CourseEnroll oldData = courseEnrollRepository.findById(id).orElseThrow(()->new EntityNotFoundException(CourseEnroll.class,"Id",String.valueOf(id)));
        if (oldData != null) {
            BeanUtils.copyProperties(courseEnroll,oldData,getNullPropertyNames(courseEnroll));
            return  enrollCourse(oldData);
        }
        return null;
    }
}
