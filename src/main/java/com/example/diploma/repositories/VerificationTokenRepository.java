package com.example.diploma.repositories;


import com.example.diploma.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    public VerificationToken findByToken(String token);
    public VerificationToken findByUserId(Long uid);
}
