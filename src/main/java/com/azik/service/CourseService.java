package com.azik.service;

import com.azik.entity.Course;
import com.azik.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Long create(Course course) {
        Course savedCourse = courseRepository.save(course);
        return savedCourse.getId();
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    public Course update(Course course) {
        Optional<Course> existingCourse = courseRepository.findById(course.getId());

        if (existingCourse.isPresent()) {
            Course updatedCourse = existingCourse.get();
            updatedCourse.setCourseName(course.getCourseName());
            updatedCourse.setDescription(course.getDescription());


            return courseRepository.save(updatedCourse);
        } else {
            System.out.println("Course not found!");
            return null;
        }
    }

    public Course getById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }


}
