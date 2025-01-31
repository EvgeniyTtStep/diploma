package com.example.diploma.repositories;


import com.example.diploma.model.Course;
import com.example.diploma.model.users.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    public Course findByNameAndSchool(String name, School school);
}
