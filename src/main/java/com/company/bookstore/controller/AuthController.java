package com.company.bookstore.controller;


import com.company.bookstore.dto.LoginDto;
import com.company.bookstore.dto.SignUpDto;
import com.company.bookstore.enumeration.RoleEnum;
import com.company.bookstore.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(value = "Auth controller exposes signin and signup REST APIs")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @ApiOperation(value = "REST API to Register or Signup user to BookStore")
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginDto loginDto) {
        return userService.authenticateUser(loginDto);
    }

    @ApiOperation(value = "REST API to Sign in or Login user to Blog app")
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Validated @RequestBody  SignUpDto signUpDto, @RequestParam RoleEnum roleEnum) {
        signUpDto.setRoleId(roleEnum.id);
        return userService.registerUser(signUpDto);

    }
}
