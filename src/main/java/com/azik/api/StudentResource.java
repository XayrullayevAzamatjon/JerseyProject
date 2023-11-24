package com.azik.api;
import com.azik.entity.Course;
import com.azik.entity.Student;
import com.azik.service.StudentService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Path("/students")
@Component
@CrossOrigin(originPatterns = "http://localhost:5173/")
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @GET()
//    @Path("/{size}/{page}")

    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents(/*@PathParam("size") Integer size, @PathParam("page") Integer page*/) {
        return studentService.getAll(/*PageRequest.of(page,size)*/);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudentById(@PathParam("id") Long id) {
        return studentService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Long createStudent(Student student) {
        return studentService.create(student);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student updateStudent(Student student) {
        return studentService.update(student);
    }

    @DELETE
    @Path("/{id}")
    public void deleteStudent(@PathParam("id") Long id) {
        studentService.delete(id);
    }
    @GET
    @Path("/{id}/course")
    public List<Course> getStudentCourses(@PathParam("id") Long id){
       return studentService.getCourses(id);
    }
}
