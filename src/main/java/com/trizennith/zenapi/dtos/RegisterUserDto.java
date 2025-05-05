package com.trizennith.zenapi.dtos;

public record RegisterUserDto(
        String fullName,
        String email,
        String password
) {
}
