package com.trizennith.zenapi.dtos;

public record LoginResponse(
        String token,
        long expiresIn
){}
