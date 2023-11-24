package com.azik.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String courseName;
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
