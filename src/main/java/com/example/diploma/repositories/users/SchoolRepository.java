package com.example.diploma.repositories.users;


import com.example.diploma.model.users.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
