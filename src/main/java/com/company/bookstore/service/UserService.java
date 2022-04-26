package com.company.bookstore.service;

import com.company.bookstore.dto.JWTAuthResponse;
import com.company.bookstore.dto.LoginDto;
import com.company.bookstore.dto.SignUpDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface UserService {
    ResponseEntity<?> registerUser(SignUpDto signUpDto);

    ResponseEntity<?> authenticateUser(LoginDto loginDto);

}
