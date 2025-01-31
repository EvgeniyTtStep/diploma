package com.example.diploma.services;


import com.example.diploma.model.VerificationToken;
import com.example.diploma.model.users.TeacherbookUser;

public interface IUserService {
    TeacherbookUser registerUser(TeacherbookUser user);
    TeacherbookUser getUser(String verificationToken);
    void saveRegisteredUser(TeacherbookUser user);
    void createVerificationToken(TeacherbookUser user, String token);
    VerificationToken getVerificationToken(String token);
}