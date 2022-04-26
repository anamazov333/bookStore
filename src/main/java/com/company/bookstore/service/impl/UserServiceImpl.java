package com.company.bookstore.service.impl;

import com.company.bookstore.dto.*;
import com.company.bookstore.entity.User;
import com.company.bookstore.mapper.UserMapper;
import com.company.bookstore.repository.UserRepository;
import com.company.bookstore.security.JwtTokenProvider;
import com.company.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;

    @Override
    public ResponseEntity<?> registerUser(SignUpDto signUpDto) {

        if (userRepository.existsByEmail(signUpDto.getEmail()))
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        signUpDto.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        User user = UserMapper.INSTANCE.signUpDtoToUser(signUpDto);
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> authenticateUser(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.generateToken(authentication);
        return new ResponseEntity<>(new JWTAuthResponse("Bearer "+token), HttpStatus.OK);

    }
}
