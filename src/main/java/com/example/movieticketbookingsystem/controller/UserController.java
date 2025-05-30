package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.dto.UserRegistrationRequest;
import com.example.movieticketbookingsystem.dto.UserResponse;
import com.example.movieticketbookingsystem.dto.UserUpdationRequest;
import com.example.movieticketbookingsystem.service.UserService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import com.example.movieticketbookingsystem.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class    UserController {

    private final UserService userService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody @Valid UserRegistrationRequest user){
        UserResponse userDetails =  userService.addUser(user);
        return restResponseBuilder.success(HttpStatus.OK,"New User Details has been added",userDetails);
    }

    @PutMapping("/users/{email}")
    public ResponseEntity<ResponseStructure<UserResponse>> editUser(@PathVariable String email,@RequestBody @Valid UserUpdationRequest user){
        UserResponse userDetails = userService.editUser(user, email);
        return restResponseBuilder.success(HttpStatus.OK,"User Details has been updated",userDetails);
    }

    @DeleteMapping("users/{email}")
    public ResponseEntity<ResponseStructure<UserResponse>> softDelete(@PathVariable String email){
        UserResponse userDetails = userService.softDeleteUser(email);
        return restResponseBuilder.success(HttpStatus.OK,"User Details account has been deleted",userDetails);
    }

}
