package com.azik.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Entity
@XmlRootElement(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlAttribute(name = "id")
    private Long id= new Random().nextLong();
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "email")
    private String email;
    @XmlAttribute(name = "age")
    private Integer age;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Course> courses = new HashSet<>();

    public String getName() {
        return name;
    }

    public Set<Course> getCourses() {
        return courses;
    }
    public void addCourse(Course course) {
        this.courses.add(course);

    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
