package com.example.diploma.model.users;


import com.example.diploma.model.Course;
import com.example.diploma.model.StudentGroup;
import com.example.diploma.model.schedulegrid.Semester;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long school_id;

    @NotNull
    private String name;

    @OneToOne(mappedBy = "school")
    private TeacherbookUser admin_user;

    @OneToMany(mappedBy = "school")
    private Collection<Teacher> teachers;

    @OneToMany(mappedBy = "school")
    private Collection<Student> students;

    //semester
    @OneToMany(mappedBy = "school")
    private Collection<Semester> semesters;

    @OneToMany(mappedBy = "school")
    private Collection<StudentGroup> groups;

    @OneToMany(mappedBy = "school")
    private Collection<Course> courses;

    //timeslots

    //schedule

    public School(String name) {
        this.name = name;
    }

    public School() {
        super();
    }

    public Long getSchool_id() {
        return school_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Teacher> getTeachers() {
        return teachers;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public Collection<Semester> getSemesters() {
        return semesters;
    }

    public Collection<StudentGroup> getGroups() {
        return groups;
    }

    public Collection<Course> getCourses() {
        return courses;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof School) && this.school_id.equals(((School) o).getSchool_id());
    }

}
