package com.azik.api;

import com.azik.entity.Course;
import com.azik.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/courses")
@Component
public class CourseResource {

    @Autowired
    private CourseService courseService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getAllCourses() {
        return courseService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Course getCourseById(@PathParam("id") Long id) {
        return courseService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Long createCourse(Course course) {
        return courseService.create(course);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Course updateCourse(Course course) {
        return courseService.update(course);
    }

    @DELETE
    @Path("/{id}")
    public void deleteCourse(@PathParam("id") Long id) {
        courseService.delete(id);
    }
}
