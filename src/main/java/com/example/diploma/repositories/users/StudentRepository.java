package com.example.diploma.repositories.users;


import com.example.diploma.model.users.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
