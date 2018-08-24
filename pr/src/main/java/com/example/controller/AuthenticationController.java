package com.example.controller;

import com.example.service.AuthenticationService;
import com.example.service.dto.AuthUserDto;
import com.example.service.dto.LoginRequestDto;
import com.example.service.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login")
    @ResponseStatus(value = HttpStatus.OK)
    public LoginResponseDto login(@RequestBody final LoginRequestDto loginRequestDto) {
        return authenticationService.login(loginRequestDto);
    }

    @GetMapping(value = "/me")
    @ResponseStatus(value = HttpStatus.OK)
    public AuthUserDto me()
    {
        return authenticationService.getMe();
    }
}

