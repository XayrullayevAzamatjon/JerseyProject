package com.azik.service;

import com.azik.entity.Course;
import com.azik.repository.CourseRepository;
import com.azik.repository.StudentRepository;
import com.azik.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public List<Student> getAll(/*Pageable pageable*/){
        return studentRepository.findAll(/*pageable*/);
    }
    public Long create(Student student){
        Student save = studentRepository.save(student);
        return save.getId();
    }
    public void delete(Long id){
        studentRepository.deleteById(id);
    }
    public Student update(Student student) {
        Optional<Student> existingStudent = studentRepository.findById(student.getId());

        if (existingStudent.isPresent()) {
            Student updatedStudent = existingStudent.get();
            updatedStudent.setName(student.getName());
            updatedStudent.setAge(student.getAge());
            updatedStudent.setEmail(student.getEmail());


            return studentRepository.save(updatedStudent);
        } else {
            System.out.println("Student not found !");
            return null;
        }
    }
    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    @Transactional
    public Long addCourse(Long studentId, Long courseId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Optional<Course> courseOptional = courseRepository.findById(courseId);

        if (studentOptional.isPresent() && courseOptional.isPresent()) {
            Student student = studentOptional.get();
            Course course = courseOptional.get();

            student.addCourse(course);

            studentRepository.save(student);

            return student.getId();
        } else {
            System.out.println("Student or Course with the given IDs is not found");
            return null;
        }
    }
    public List<Course> getCourses(Long id){
        Student student = studentRepository.findById(id).get();
        return student.getCourses().stream().toList();
    }
}
