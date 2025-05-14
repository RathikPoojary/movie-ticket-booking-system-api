package com.example.movieticketbookingsystem.mapper.auth;

import com.example.movieticketbookingsystem.dto.auth.AuthResponse;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.security.jwt.TokenPayLoad;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {


    public AuthResponse authResponseMapper(UserDetails userDetails, TokenPayLoad access, TokenPayLoad refresh, String accessToken, String refreshToken) {

        return AuthResponse.builder()
                .userId(userDetails.getUserId())
                .username(userDetails.getUsername())
                .email(userDetails.getEmail())
                .role(userDetails.getUserRole().toString())
                .accessExpiration(access.expiration().toEpochMilli())
                .refreshExpiration(refresh.expiration().toEpochMilli())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .refreshToken(refreshToken)
                .build();

    }
}