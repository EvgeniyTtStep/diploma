package com.example.diploma.repositories.users;


import com.example.diploma.model.users.School;
import com.example.diploma.model.users.TeacherbookUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TeacherbookUser, Long> {
    TeacherbookUser findByUsername(String username);
    TeacherbookUser findByUsernameAndSchool(String username, School school);
}
