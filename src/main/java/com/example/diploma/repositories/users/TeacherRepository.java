package com.example.diploma.repositories.users;


import com.example.diploma.model.users.School;
import com.example.diploma.model.users.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    public Teacher findByFullnameAndSchool(String fullname, School school);
}
