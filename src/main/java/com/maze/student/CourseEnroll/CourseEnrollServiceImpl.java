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
        Page<CoursEnroll> courses = courseEnrollRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(courses.getContent()))
            return pagedResourcesAssembler.toModel(courses, courseEnrollAssembler);

        return null;
    }

    @Override
    public CourseEnrollDTO enrollCourse(CoursEnroll coursEnroll) {
        return courseEnrollAssembler.toModel(courseEnrollRepository.save(coursEnroll));
    }

    @Override
    public CourseEnrollDTO findCourseById(Long id) {
        CoursEnroll coursEnroll = courseEnrollRepository.findById(id).orElse(null);
        if (coursEnroll != null) {
            return courseEnrollAssembler.toModel(coursEnroll);
        }
        return null;
    }

    @Override
    public CourseEnrollDTO updateCourseEnroll(Long id, CoursEnroll coursEnroll) {
        CoursEnroll oldData = courseEnrollRepository.findById(id).orElseThrow(()->new EntityNotFoundException(CoursEnroll.class,"Id",String.valueOf(id)));
        if (oldData != null) {
            BeanUtils.copyProperties(coursEnroll,oldData,getNullPropertyNames(coursEnroll));
            return  enrollCourse(oldData);
        }
        return null;
    }
}
