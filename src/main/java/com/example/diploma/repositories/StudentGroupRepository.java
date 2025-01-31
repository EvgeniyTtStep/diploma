package com.example.diploma.repositories;


import com.example.diploma.model.StudentGroup;
import com.example.diploma.model.users.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {
    public StudentGroup findByNameAndSchool(String name, School school);
}
